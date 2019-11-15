package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getRemoveBackgroundOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_REMOVE_BACKGROUND

object RemoveBackgroundParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        if (parameters.getRemoveBackgroundOrNull() ?: defaultParameters.removeBackground == true) {
            listOf(PARAMETER_REMOVE_BACKGROUND)
        } else {
            emptyList()
        }
}