package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test

class OcrMyPdfOcrParametersDslTest {

    companion object {
        private const val language = "eng"
        private const val pdfRenderer = "sandwich"
        private const val rotatePages = true
        private const val rotatePagesThreshold = 1.111f
        private const val removeBackground = false
        private const val optimize = 1
        private const val oversample = 300
        private const val redoOcr = false
        private const val forceOcr = true
        private const val deskew = true
        private const val skipText = false
        private const val clean = true
        private const val cleanFinal = true
        private const val skipBig = 50.111f
        private const val unpaperArgs = "--no-noisefilter"
        private const val tesseractTimeout = 60
    }

    @Test
    fun `ocrMyPdfOcrParameters _ default parameters`() {
        ocrMyPdfOcrParameters().let {
            shouldThrow<NoSuchElementException> {
                it.getLanguage()
            }
            it.getLanguageOrNull() shouldBe null
            it.getLanguageOrDefault(language) shouldBe language

            shouldThrow<NoSuchElementException> {
                it.getPdfRenderer()
            }
            it.getPdfRendererOrNull() shouldBe null
            it.getPdfRendererOrDefault(pdfRenderer) shouldBe pdfRenderer

            shouldThrow<NoSuchElementException> {
                it.getRotatePages()
            }
            it.getRotatePagesOrNull() shouldBe null
            it.getRotatePagesOrDefault(rotatePages) shouldBe rotatePages

            shouldThrow<NoSuchElementException> {
                it.getRotatePagesThreshold()
            }
            it.getRotatePagesThresholdOrNull() shouldBe null
            it.getRotatePagesThresholdOrDefault(rotatePagesThreshold) shouldBe rotatePagesThreshold

            shouldThrow<NoSuchElementException> {
                it.getRemoveBackground()
            }
            it.getRemoveBackgroundOrNull() shouldBe null
            it.getRemoveBackgroundOrDefault(removeBackground) shouldBe removeBackground

            shouldThrow<NoSuchElementException> {
                it.getOptimize()
            }
            it.getOptimizeOrNull() shouldBe null
            it.getOptimizeOrDefault(optimize) shouldBe optimize

            shouldThrow<NoSuchElementException> {
                it.getOversample()
            }
            it.getOversampleOrNull() shouldBe null
            it.getOversampleOrDefault(oversample) shouldBe oversample

            shouldThrow<NoSuchElementException> {
                it.getRedoOcr()
            }
            it.getRedoOcrOrNull() shouldBe null
            it.getRedoOcrOrDefault(redoOcr) shouldBe redoOcr

            shouldThrow<NoSuchElementException> {
                it.getForceOcr()
            }
            it.getForceOcrOrNull() shouldBe null
            it.getForceOcrOrDefault(forceOcr) shouldBe forceOcr

            shouldThrow<NoSuchElementException> {
                it.getDeskew()
            }
            it.getDeskewOrNull() shouldBe null
            it.getDeskewOrDefault(deskew) shouldBe deskew

            shouldThrow<NoSuchElementException> {
                it.getSkipText()
            }
            it.getSkipTextOrNull() shouldBe null
            it.getSkipTextOrDefault(skipText) shouldBe skipText

            shouldThrow<NoSuchElementException> {
                it.getClean()
            }
            it.getCleanOrNull() shouldBe null
            it.getCleanOrDefault(clean) shouldBe clean

            shouldThrow<NoSuchElementException> {
                it.getCleanFinal()
            }
            it.getCleanFinalOrNull() shouldBe null
            it.getCleanFinalOrDefault(cleanFinal) shouldBe cleanFinal

            shouldThrow<NoSuchElementException> {
                it.getSkipBig()
            }
            it.getSkipBigOrNull() shouldBe null
            it.getSkipBigOrDefault(skipBig) shouldBe skipBig

            shouldThrow<NoSuchElementException> {
                it.getUnpaperArgs()
            }
            it.getUnpaperArgsOrNull() shouldBe null
            it.getUnpaperArgsOrDefault(unpaperArgs) shouldBe unpaperArgs

            shouldThrow<NoSuchElementException> {
                it.getTesseractTimeout()
            }
            it.getTesseractTimeoutOrNull() shouldBe null
            it.getTesseractTimeoutOrDefault(tesseractTimeout) shouldBe tesseractTimeout
        }
    }

    @Test
    fun `ocrMyPdfOcrParameters _ all parameters`() {
        ocrMyPdfOcrParameters(
            language = language,
            pdfRenderer = pdfRenderer,
            rotatePages = rotatePages,
            rotatePagesThreshold = rotatePagesThreshold,
            removeBackground = removeBackground,
            optimize = optimize,
            oversample = oversample,
            redoOcr = redoOcr,
            forceOcr = forceOcr,
            deskew = deskew,
            skipText = skipText,
            clean = clean,
            cleanFinal = cleanFinal,
            skipBig = skipBig,
            unpaperArgs = unpaperArgs,
            tesseractTimeout = tesseractTimeout
        ).let {
            it.getLanguage() shouldBe language
            it.getPdfRenderer() shouldBe pdfRenderer
            it.getRotatePages() shouldBe rotatePages
            it.getRotatePagesThreshold() shouldBe rotatePagesThreshold
            it.getRemoveBackground() shouldBe removeBackground
            it.getOptimize() shouldBe optimize
            it.getOversample() shouldBe oversample
            it.getRedoOcr() shouldBe redoOcr
            it.getForceOcr() shouldBe forceOcr
            it.getDeskew() shouldBe deskew
            it.getSkipText() shouldBe skipText
            it.getClean() shouldBe clean
            it.getCleanFinal() shouldBe cleanFinal
            it.getSkipBig() shouldBe skipBig
            it.getUnpaperArgs() shouldBe unpaperArgs
            it.getTesseractTimeout() shouldBe tesseractTimeout
        }
    }
}