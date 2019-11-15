package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrConstants.TRANSFORMER_ID

class OcrMyPdfOcrDslTest {

    @Test
    fun ocrMyPdfOcrTransformation() {
        ocrMyPdfOcrTransformation(APPLICATION_PDF, ocrMyPdfOcrParameters()).let {
            it.transformerId shouldBe TRANSFORMER_ID
            it.targetMediaType shouldBe APPLICATION_PDF
            it.parameters.getAll().size shouldBe 0
        }
    }
}