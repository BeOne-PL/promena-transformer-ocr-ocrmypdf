package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getSkipTextOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_SKIP_TEXT

object SkipTextParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        if (parameters.getSkipTextOrNull() ?: defaultParameters.skipText == true) {
            listOf(PARAMETER_SKIP_TEXT)
        } else {
            emptyList()
        }
}