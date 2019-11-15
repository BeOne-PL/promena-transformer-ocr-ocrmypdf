package pl.beone.promena.transformer.ocr.ocrmypdf.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.configuration.extension.getNotBlankProperty
import pl.beone.promena.transformer.ocr.ocrmypdf.configuration.extension.getRequiredNotBlankProperty
import pl.beone.promena.transformer.ocr.ocrmypdf.configuration.extension.toDuration

@Configuration
class OcrMyPdfOcrTransformerConfigurationContext {

    companion object {
        private const val PROPERTY_PREFIX = "transformer.pl.beone.promena.transformer.ocr.ocrmypdf"
    }

    @Bean
    fun ocrMyPdfOcrTransformerDefaultParameters(environment: Environment): OcrMyPdfOcrTransformerDefaultParameters =
        OcrMyPdfOcrTransformerDefaultParameters(
            environment.getRequiredNotBlankProperty("$PROPERTY_PREFIX.default.parameters.language"),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.pdf-renderer"),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.rotate-pages")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.rotate-pages-threshold")?.toFloat(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.remove-background")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.optimize")?.toInt(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.oversample")?.toInt(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.redo-ocr")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.force-ocr")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.deskew")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.skip-text")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.clean")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.clean-final")?.toBoolean(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.skip-big")?.toFloat(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.unpaper-args"),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.tesseract-timeout")?.toInt(),
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.timeout")?.toDuration()
        )
}