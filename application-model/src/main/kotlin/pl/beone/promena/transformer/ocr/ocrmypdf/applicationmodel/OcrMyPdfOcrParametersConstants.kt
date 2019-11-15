package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

object OcrMyPdfOcrParametersConstants {

    object Language {
        const val NAME = "language"
        @JvmField
        val CLASS = String::class.java
    }

    object PdfRenderer {
        const val NAME = "pdfRenderer"
        @JvmField
        val CLASS = String::class.java
    }

    object RotatePages {
        const val NAME = "rotatePages"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object RotatePagesThreshold {
        const val NAME = "rotatePagesThreshold"
        @JvmField
        val CLASS = Float::class.java
    }

    object RemoveBackground {
        const val NAME = "removeBackground"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object Optimize {
        const val NAME = "optimize"
        @JvmField
        val CLASS = Int::class.java
    }

    object Oversample {
        const val NAME = "oversample"
        @JvmField
        val CLASS = Int::class.java
    }

    object RedoOcr {
        const val NAME = "redoOcr"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object ForceOcr {
        const val NAME = "forceOcr"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object Deskew {
        const val NAME = "deskew"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object SkipText {
        const val NAME = "skipText"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object Clean {
        const val NAME = "clean"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object CleanFinal {
        const val NAME = "cleanFinal"
        @JvmField
        val CLASS = Boolean::class.java
    }

    object SkipBig {
        const val NAME = "skipBig"
        @JvmField
        val CLASS = Float::class.java
    }

    object UnpaperArgs {
        const val NAME = "unpaperArgs"
        @JvmField
        val CLASS = String::class.java
    }

    object TesseractTimeout {
        const val NAME = "tesseractTimeout"
        @JvmField
        val CLASS = Int::class.java
    }
}