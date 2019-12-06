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
        with(ocrMyPdfOcrParameters()) {
            shouldThrow<NoSuchElementException> { getLanguage() }
            getLanguageOrNull() shouldBe null
            getLanguageOrDefault(language) shouldBe language

            shouldThrow<NoSuchElementException> { getPdfRenderer() }
            getPdfRendererOrNull() shouldBe null
            getPdfRendererOrDefault(pdfRenderer) shouldBe pdfRenderer

            shouldThrow<NoSuchElementException> { getRotatePages() }
            getRotatePagesOrNull() shouldBe null
            getRotatePagesOrDefault(rotatePages) shouldBe rotatePages

            shouldThrow<NoSuchElementException> { getRotatePagesThreshold() }
            getRotatePagesThresholdOrNull() shouldBe null
            getRotatePagesThresholdOrDefault(rotatePagesThreshold) shouldBe rotatePagesThreshold

            shouldThrow<NoSuchElementException> { getRemoveBackground() }
            getRemoveBackgroundOrNull() shouldBe null
            getRemoveBackgroundOrDefault(removeBackground) shouldBe removeBackground

            shouldThrow<NoSuchElementException> { getOptimize() }
            getOptimizeOrNull() shouldBe null
            getOptimizeOrDefault(optimize) shouldBe optimize

            shouldThrow<NoSuchElementException> { getOversample() }
            getOversampleOrNull() shouldBe null
            getOversampleOrDefault(oversample) shouldBe oversample

            shouldThrow<NoSuchElementException> { getRedoOcr() }
            getRedoOcrOrNull() shouldBe null
            getRedoOcrOrDefault(redoOcr) shouldBe redoOcr

            shouldThrow<NoSuchElementException> { getForceOcr() }
            getForceOcrOrNull() shouldBe null
            getForceOcrOrDefault(forceOcr) shouldBe forceOcr

            shouldThrow<NoSuchElementException> { getDeskew() }
            getDeskewOrNull() shouldBe null
            getDeskewOrDefault(deskew) shouldBe deskew

            shouldThrow<NoSuchElementException> { getSkipText() }
            getSkipTextOrNull() shouldBe null
            getSkipTextOrDefault(skipText) shouldBe skipText

            shouldThrow<NoSuchElementException> { getClean() }
            getCleanOrNull() shouldBe null
            getCleanOrDefault(clean) shouldBe clean

            shouldThrow<NoSuchElementException> { getCleanFinal() }
            getCleanFinalOrNull() shouldBe null
            getCleanFinalOrDefault(cleanFinal) shouldBe cleanFinal

            shouldThrow<NoSuchElementException> { getSkipBig() }
            getSkipBigOrNull() shouldBe null
            getSkipBigOrDefault(skipBig) shouldBe skipBig

            shouldThrow<NoSuchElementException> { getUnpaperArgs() }
            getUnpaperArgsOrNull() shouldBe null
            getUnpaperArgsOrDefault(unpaperArgs) shouldBe unpaperArgs

            shouldThrow<NoSuchElementException> { getTesseractTimeout() }
            getTesseractTimeoutOrNull() shouldBe null
            getTesseractTimeoutOrDefault(tesseractTimeout) shouldBe tesseractTimeout
        }
    }

    @Test
    fun `ocrMyPdfOcrParameters _ all parameters`() {
        with(
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
            )
        ) {
            getLanguage() shouldBe language
            getPdfRenderer() shouldBe pdfRenderer
            getRotatePages() shouldBe rotatePages
            getRotatePagesThreshold() shouldBe rotatePagesThreshold
            getRemoveBackground() shouldBe removeBackground
            getOptimize() shouldBe optimize
            getOversample() shouldBe oversample
            getRedoOcr() shouldBe redoOcr
            getForceOcr() shouldBe forceOcr
            getDeskew() shouldBe deskew
            getSkipText() shouldBe skipText
            getClean() shouldBe clean
            getCleanFinal() shouldBe cleanFinal
            getSkipBig() shouldBe skipBig
            getUnpaperArgs() shouldBe unpaperArgs
            getTesseractTimeout() shouldBe tesseractTimeout
        }
    }
}