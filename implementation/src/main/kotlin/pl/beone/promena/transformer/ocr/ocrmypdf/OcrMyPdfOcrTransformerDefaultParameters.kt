package pl.beone.promena.transformer.ocr.ocrmypdf

import java.time.Duration

data class OcrMyPdfOcrTransformerDefaultParameters(
    val language: String,
    val pdfRenderer: String? = null,
    val rotatePages: Boolean? = null,
    val rotatePagesThreshold: Float? = null,
    val removeBackground: Boolean? = null,
    val optimize: Int? = null,
    val oversample: Int? = null,
    val redoOcr: Boolean? = null,
    val forceOcr: Boolean? = null,
    val deskew: Boolean? = null,
    val skipText: Boolean? = null,
    val clean: Boolean? = null,
    val cleanFinal: Boolean? = null,
    val skipBig: Float? = null,
    val unpaperArgs: String? = null,
    val tesseractTimeout: Int? = null,
    val timeout: Duration? = null
)