package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getRotatePagesThresholdOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_ROTATE_PAGES_THRESHOLD

object RotatePagesThresholdParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        eitherNotNullValueOrEmptyList(PARAMETER_ROTATE_PAGES_THRESHOLD, parameters.getRotatePagesThresholdOrNull(), defaultParameters.rotatePagesThreshold)
}