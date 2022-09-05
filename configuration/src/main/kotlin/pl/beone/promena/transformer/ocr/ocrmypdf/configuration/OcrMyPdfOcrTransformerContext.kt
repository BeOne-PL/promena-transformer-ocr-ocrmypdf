package pl.beone.promena.transformer.ocr.ocrmypdf.configuration

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformer
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerSettings

@Configuration
class OcrMyPdfOcrTransformerContext {

    @Bean
    fun ocrMyPdfOcrTransformer(
        settings: OcrMyPdfOcrTransformerSettings,
        defaultParameters: OcrMyPdfOcrTransformerDefaultParameters,
        @Qualifier("internalCommunicationParameters") communicationParameters: CommunicationParameters,
        @Qualifier("internalCommunicationWritableDataCreator") communicationWritableDataCreator: CommunicationWritableDataCreator
    ) =
        OcrMyPdfOcrTransformer(
            settings,
            defaultParameters,
            communicationParameters,
            communicationWritableDataCreator
        )
}