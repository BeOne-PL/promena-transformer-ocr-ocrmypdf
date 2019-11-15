package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getLanguageOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_LANGUAGE

object LanguageParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        eitherNotNullValueOrEmptyList(PARAMETER_LANGUAGE, parameters.getLanguageOrNull(), defaultParameters.language)
}