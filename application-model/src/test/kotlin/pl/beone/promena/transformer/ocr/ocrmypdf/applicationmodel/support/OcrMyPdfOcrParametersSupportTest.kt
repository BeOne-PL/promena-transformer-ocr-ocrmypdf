package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.support

import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrSupport.ParametersSupport.isSupported
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrParameters

class OcrMyPdfOcrParametersSupportTest {

    @Test
    fun `isSupported _ default parameters`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters())
        }
    }

    @Test
    fun `isSupported _ pdfRenderer`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(pdfRenderer = "auto"))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(pdfRenderer = "hocr"))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(pdfRenderer = "sandwich"))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(pdfRenderer = "invalid"))
        }
    }

    @Test
    fun `isSupported _ rotatePagesThreshold`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(rotatePagesThreshold = 0.0f))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(rotatePagesThreshold = 100.55f))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(rotatePagesThreshold = 1000.0f))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(rotatePagesThreshold = -0.1f))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(rotatePagesThreshold = 1000.1f))
        }
    }

    @Test
    fun `isSupported _ optimize`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(optimize = 0))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(optimize = 1))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(optimize = 2))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(optimize = 3))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(optimize = 4))
        }
    }

    @Test
    fun `isSupported _ oversample`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(oversample = 0))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(oversample = 100))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(oversample = 5000))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(oversample = -1))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(oversample = 5001))
        }
    }

    @Test
    fun `isSupported _ skipBig`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipBig = 0.0f))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipBig = 100.0f))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipBig = 5000.0f))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipBig = -0.1f))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipBig = 5000.1f))
        }
    }

    @Test
    fun `isSupported _ redoOcr compatibility`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = false, deskew = true, cleanFinal = true, removeBackground = true))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = true, deskew = true, cleanFinal = true, removeBackground = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = true, deskew = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = true, cleanFinal = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = true, removeBackground = true))
        }
    }

    @Test
    fun `isSupported _ unpaperArgs compatibility`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(unpaperArgs = "--no-noisefilter", clean = true))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(unpaperArgs = "--no-noisefilter", clean = false))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(unpaperArgs = "--no-noisefilter"))
        }
    }

    @Test
    fun `isSupported _ only one of forceOcr, skipText and redoOcr`() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(forceOcr = true))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipText = true))
        }
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(redoOcr = true))
        }

        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(forceOcr = true, skipText = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(skipText = true, redoOcr = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(forceOcr = true, redoOcr = true))
        }
        shouldThrow<TransformationNotSupportedException> {
            isSupported(ocrMyPdfOcrParameters(forceOcr = true, skipText = true, redoOcr = true))
        }
    }
}