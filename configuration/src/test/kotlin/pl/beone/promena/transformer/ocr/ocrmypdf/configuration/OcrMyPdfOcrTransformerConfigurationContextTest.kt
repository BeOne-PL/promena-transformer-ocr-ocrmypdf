package pl.beone.promena.transformer.ocr.ocrmypdf.configuration

import io.kotlintest.shouldBe
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.mock.env.MockEnvironment
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import java.time.Duration

class OcrMyPdfOcrTransformerConfigurationContextTest {

    @Test
    fun `setting context _ default values`() {
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
        applicationContext.getBean(OcrMyPdfOcrTransformerDefaultParameters::class.java).let {
            it.language shouldBe "pol+eng"
            it.pdfRenderer shouldBe null
            it.rotatePages shouldBe null
            it.rotatePagesThreshold shouldBe null
            it.removeBackground shouldBe null
            it.optimize shouldBe null
            it.oversample shouldBe null
            it.redoOcr shouldBe null
            it.forceOcr shouldBe null
            it.deskew shouldBe null
            it.skipText shouldBe null
            it.clean shouldBe null
            it.cleanFinal shouldBe null
            it.skipBig shouldBe null
            it.unpaperArgs shouldBe null
            it.tesseractTimeout shouldBe null
            it.timeout shouldBe null
        }
    }

    @Test
    fun `setting context`() {
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
        applicationContext.getBean(OcrMyPdfOcrTransformerDefaultParameters::class.java).let {
            it.language shouldBe "pol+eng"
            it.pdfRenderer shouldBe "sandwich"
            it.rotatePages shouldBe true
            it.rotatePagesThreshold shouldBe 1.111f
            it.removeBackground shouldBe false
            it.optimize shouldBe 1
            it.oversample shouldBe 300
            it.redoOcr shouldBe false
            it.forceOcr shouldBe true
            it.deskew shouldBe true
            it.skipText shouldBe false
            it.clean shouldBe true
            it.cleanFinal shouldBe true
            it.skipBig shouldBe 50.111f
            it.unpaperArgs shouldBe "--no-noisefilter"
            it.tesseractTimeout shouldBe 60
            it.timeout shouldBe Duration.ofMinutes(5)
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