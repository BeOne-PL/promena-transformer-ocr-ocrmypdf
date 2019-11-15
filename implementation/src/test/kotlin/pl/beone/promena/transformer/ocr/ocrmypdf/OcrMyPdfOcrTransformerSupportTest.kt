package pl.beone.promena.transformer.ocr.ocrmypdf

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrSupport
import pl.beone.promena.transformer.ocr.ocrmypdf.util.createOcrMyPdfOcrTransformer

@ExtendWith(DockerExtension::class)
class OcrMyPdfOcrTransformerSupportTest {

    @Test
    fun isSupported() {
        val dataDescriptor = mockk<DataDescriptor>()
        val targetMediaType = mockk<MediaType>()
        val parameters = mockk<Parameters>()

        mockkStatic(OcrMyPdfOcrSupport::class)
        every { OcrMyPdfOcrSupport.isSupported(dataDescriptor, targetMediaType, parameters) } just Runs

        createOcrMyPdfOcrTransformer()
            .isSupported(dataDescriptor, targetMediaType, parameters)

        verify(exactly = 1) { OcrMyPdfOcrSupport.isSupported(dataDescriptor, targetMediaType, parameters) }
    }
}