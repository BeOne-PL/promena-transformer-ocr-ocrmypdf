package pl.beone.promena.transformer.ocr.ocrmypdf.configuration

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.mock.env.MockEnvironment
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import java.time.Duration

class OcrMyPdfOcrTransformerConfigurationContextTest {

    @Test
    fun `setting context _ default`() {
        val environment = createEnvironment(
            mapOf(
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.language" to "pol+eng",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.pdf-renderer" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages-threshold" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.remove-background" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.optimize" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.oversample" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.redo-ocr" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.force-ocr" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.deskew" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-text" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean-final" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-big" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.unpaper-args" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.tesseract-timeout" to "",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.timeout" to ""
            )
        )

        val applicationContext = createConfigApplicationContext(environment, OcrMyPdfOcrTransformerConfigurationContext::class.java)
        with(applicationContext.getBean(OcrMyPdfOcrTransformerDefaultParameters::class.java)) {
            language shouldBe "pol+eng"
            pdfRenderer shouldBe null
            rotatePages shouldBe null
            rotatePagesThreshold shouldBe null
            removeBackground shouldBe null
            optimize shouldBe null
            oversample shouldBe null
            redoOcr shouldBe null
            forceOcr shouldBe null
            deskew shouldBe null
            skipText shouldBe null
            clean shouldBe null
            cleanFinal shouldBe null
            skipBig shouldBe null
            unpaperArgs shouldBe null
            tesseractTimeout shouldBe null
            timeout shouldBe null
        }
    }

    @Test
    fun `setting context _ all`() {
        val environment = createEnvironment(
            mapOf(
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.language" to "pol+eng",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.pdf-renderer" to "sandwich",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages" to "true",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages-threshold" to "1.111",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.remove-background" to "false",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.optimize" to "1",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.oversample" to "300",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.redo-ocr" to "false",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.force-ocr" to "true",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.deskew" to "true",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-text" to "false",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean" to "true",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean-final" to "true",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-big" to "50.111",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.unpaper-args" to "--no-noisefilter",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.tesseract-timeout" to "60",
                "transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.timeout" to "5m"
            )
        )

        val applicationContext = createConfigApplicationContext(environment, OcrMyPdfOcrTransformerConfigurationContext::class.java)
        with(applicationContext.getBean(OcrMyPdfOcrTransformerDefaultParameters::class.java)) {
            language shouldBe "pol+eng"
            pdfRenderer shouldBe "sandwich"
            rotatePages shouldBe true
            rotatePagesThreshold shouldBe 1.111f
            removeBackground shouldBe false
            optimize shouldBe 1
            oversample shouldBe 300
            redoOcr shouldBe false
            forceOcr shouldBe true
            deskew shouldBe true
            skipText shouldBe false
            clean shouldBe true
            cleanFinal shouldBe true
            skipBig shouldBe 50.111f
            unpaperArgs shouldBe "--no-noisefilter"
            tesseractTimeout shouldBe 60
            timeout shouldBe Duration.ofMinutes(5)
        }
    }

    private fun createEnvironment(properties: Map<String, String>): MockEnvironment =
        MockEnvironment()
            .apply { properties.forEach { (key, value) -> setProperty(key, value) } }

    private fun createConfigApplicationContext(environment: ConfigurableEnvironment, clazz: Class<*>): AnnotationConfigApplicationContext =
        AnnotationConfigApplicationContext().apply {
            this.environment = environment
            register(clazz)
            refresh()
        }
}