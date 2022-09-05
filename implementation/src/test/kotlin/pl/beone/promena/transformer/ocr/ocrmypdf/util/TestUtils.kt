package pl.beone.promena.transformer.ocr.ocrmypdf.util

import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.matchers.withClue
import io.kotlintest.shouldBe
import io.mockk.mockk
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.contract.model.data.WritableData
import pl.beone.promena.transformer.internal.model.data.memory.emptyMemoryWritableData
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformer
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerSettings
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrParameters

internal object MemoryCommunicationWritableDataCreator : CommunicationWritableDataCreator {
    override fun create(communicationParameters: CommunicationParameters): WritableData = emptyMemoryWritableData()
}

internal fun createOcrMyPdfOcrTransformer(
    settings: OcrMyPdfOcrTransformerSettings = OcrMyPdfOcrTransformerSettings(numberOfActors = 3),
    parameters: OcrMyPdfOcrTransformerDefaultParameters = OcrMyPdfOcrTransformerDefaultParameters("pol+eng"),
    communicationParameters: CommunicationParameters = mockk(),
    communicationWritableDataCreator: CommunicationWritableDataCreator = MemoryCommunicationWritableDataCreator
): OcrMyPdfOcrTransformer =
    OcrMyPdfOcrTransformer(settings, parameters, communicationParameters, communicationWritableDataCreator)

internal fun pdfTest(
    resourcePath: String,
    assertStrings: List<String>,
    parameters: Parameters = ocrMyPdfOcrParameters(),
    createData: (ByteArray) -> Data = { it.toMemoryData() }
) {
    test(resourcePath, APPLICATION_PDF, assertStrings, parameters, createData) { it.data.readText() }
}

internal fun textTest(
    resourcePath: String,
    assertStrings: List<String>,
    parameters: Parameters = ocrMyPdfOcrParameters(),
    createData: (ByteArray) -> Data = { it.toMemoryData() }
) {
    test(resourcePath, TEXT_PLAIN, assertStrings, parameters, createData) { String(it.data.getBytes()) }
}

internal fun test(
    resourcePath: String,
    targetMediaType: MediaType,
    assertString: List<String>,
    parameters: Parameters,
    createData: (ByteArray) -> Data,
    extractText: (TransformedDataDescriptor.Single) -> String
) {
    val data = createData(getResourceAsBytes(resourcePath))

    with(
        createOcrMyPdfOcrTransformer()
            .transform(singleDataDescriptor(data, APPLICATION_PDF, emptyMetadata()), targetMediaType, parameters)
    ) {
        withClue("Transformed data should contain only <1> element") { descriptors shouldHaveSize 1 }

        with(descriptors[0]) {
            val text = extractText(this)
            assertString.forEach { text shouldContain it }
            this.metadata shouldBe emptyMetadata()
        }
    }
}

private fun Data.readText(): String =
    PDDocument.load(getInputStream()).use { document ->
        PDFTextStripper().getText(document)
    }