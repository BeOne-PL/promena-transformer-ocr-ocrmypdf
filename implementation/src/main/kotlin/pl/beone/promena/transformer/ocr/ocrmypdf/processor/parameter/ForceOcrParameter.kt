package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getForceOcrOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_FORCE_OCR

object ForceOcrParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        if (parameters.getForceOcrOrNull() ?: defaultParameters.forceOcr == true) {
            listOf(PARAMETER_FORCE_OCR)
        } else {
            emptyList()
        }
}