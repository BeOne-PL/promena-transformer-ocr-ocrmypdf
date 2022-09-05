package pl.beone.promena.transformer.ocr.ocrmypdf.configuration

import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformer
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerSettings
import javax.annotation.PostConstruct

@Configuration
class OcrMyPdfOcrTransformerLogger(
    private val settings: OcrMyPdfOcrTransformerSettings,
    private val defaultParameters: OcrMyPdfOcrTransformerDefaultParameters
) {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @PostConstruct
    private fun log() {
        logger.info {
            "Run <${OcrMyPdfOcrTransformer::class.java.canonicalName}> with <$settings> and <$defaultParameters>"
        }
    }
}