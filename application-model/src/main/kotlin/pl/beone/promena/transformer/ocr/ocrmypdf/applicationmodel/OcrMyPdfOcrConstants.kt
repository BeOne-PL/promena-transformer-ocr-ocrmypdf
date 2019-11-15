package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import pl.beone.promena.transformer.contract.transformer.transformerId

object OcrMyPdfOcrConstants {

    const val TRANSFORMER_NAME = "ocr"

    const val TRANSFORMER_SUB_NAME = "OCRmyPDF"

    @JvmField
    val TRANSFORMER_ID = transformerId(TRANSFORMER_NAME, TRANSFORMER_SUB_NAME)
}