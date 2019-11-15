package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test

class OcrMyPdfOcrParametersDslTest {

    @Test
    fun `ocrMyPdfOcrParameters _ default parameters`() {
        ocrMyPdfOcrParameters().let {
            shouldThrow<NoSuchElementException> {
                it.getLanguage()
            }
            it.getLanguageOrNull() shouldBe null
            it.getLanguageOrDefault("pol+eng") shouldBe "pol+eng"

            shouldThrow<NoSuchElementException> {
                it.getPdfRenderer()
            }
            it.getPdfRendererOrNull() shouldBe null
            it.getPdfRendererOrDefault("hocr") shouldBe "hocr"

            shouldThrow<NoSuchElementException> {
                it.getRotatePages()
            }
            it.getRotatePagesOrNull() shouldBe null
            it.getRotatePagesOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getRotatePagesThreshold()
            }
            it.getRotatePagesThresholdOrNull() shouldBe null
            it.getRotatePagesThresholdOrDefault(1.0f) shouldBe 1.0f

            shouldThrow<NoSuchElementException> {
                it.getRemoveBackground()
            }
            it.getRemoveBackgroundOrNull() shouldBe null
            it.getRemoveBackgroundOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getOptimize()
            }
            it.getOptimizeOrNull() shouldBe null
            it.getOptimizeOrDefault(2) shouldBe 2

            shouldThrow<NoSuchElementException> {
                it.getOversample()
            }
            it.getOversampleOrNull() shouldBe null
            it.getOversampleOrDefault(1) shouldBe 1

            shouldThrow<NoSuchElementException> {
                it.getRedoOcr()
            }
            it.getRedoOcrOrNull() shouldBe null
            it.getRedoOcrOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getForceOcr()
            }
            it.getForceOcrOrNull() shouldBe null
            it.getForceOcrOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getDeskew()
            }
            it.getDeskewOrNull() shouldBe null
            it.getDeskewOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getSkipText()
            }
            it.getSkipTextOrNull() shouldBe null
            it.getSkipTextOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getClean()
            }
            it.getCleanOrNull() shouldBe null
            it.getCleanOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getCleanFinal()
            }
            it.getCleanFinalOrNull() shouldBe null
            it.getCleanFinalOrDefault(true) shouldBe true

            shouldThrow<NoSuchElementException> {
                it.getSkipBig()
            }
            it.getSkipBigOrNull() shouldBe null
            it.getSkipBigOrDefault(5.0f) shouldBe 5.0f

            shouldThrow<NoSuchElementException> {
                it.getUnpaperArgs()
            }
            it.getUnpaperArgsOrNull() shouldBe null
            it.getUnpaperArgsOrDefault("--layout double") shouldBe "--layout double"

            shouldThrow<NoSuchElementException> {
                it.getTesseractTimeout()
            }
            it.getTesseractTimeoutOrNull() shouldBe null
            it.getTesseractTimeoutOrDefault(100) shouldBe 100
        }
    }

    @Test
    fun `ocrMyPdfOcrParameters _ all parameters`() {
        val language = "eng"
        val pdfRenderer = "sandwich"
        val rotatePages = true
        val rotatePagesThreshold = 1.111f
        val removeBackground = false
        val optimize = 1
        val oversample = 300
        val redoOcr = false
        val forceOcr = true
        val deskew = true
        val skipText = false
        val clean = true
        val cleanFinal = true
        val skipBig = 50.111f
        val unpaperArgs = "--no-noisefilter"
        val tesseractTimeout = 60

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