package pl.beone.promena.transformer.ocr.ocrmypdf

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.model.Resource.Document.HELLO_WORLD_WITH_ORDINARY_TEXT
import pl.beone.promena.transformer.ocr.ocrmypdf.util.textTest

@ExtendWith(DockerExtension::class)
class OcrMyPdfOcrTransformerVariousTest {

    @Test
    fun transform_plainText_defaultParameters_shouldRecogniseImageAndReadText() {
        textTest(HELLO_WORLD_WITH_ORDINARY_TEXT, listOf("Hello World!", "Ordinary text"), ocrMyPdfOcrParameters(forceOcr = true))
    }
}