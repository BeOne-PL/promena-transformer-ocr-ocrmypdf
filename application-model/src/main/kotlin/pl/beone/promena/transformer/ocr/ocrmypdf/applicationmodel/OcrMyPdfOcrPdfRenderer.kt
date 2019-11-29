package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

enum class OcrMyPdfOcrPdfRenderer(
    val value: String
) {
    AUTO("auto"),
    HOCR("hocr"),
    SANDWICH("sandwich");

    companion object {
        fun of(format: String): OcrMyPdfOcrPdfRenderer =
            values().firstOrNull { it.value == format }
                ?: throw IllegalArgumentException("Pdf render <$format> isn't supported. Available renders: ${getStringPdfRenders()}")

        fun getStringPdfRenders(): List<String> =
            values().map(OcrMyPdfOcrPdfRenderer::value)
    }
}