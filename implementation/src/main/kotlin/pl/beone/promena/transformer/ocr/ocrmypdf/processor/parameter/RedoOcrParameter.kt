package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.getRedoOcrOrNull
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_REDO_OCR

object RedoOcrParameter : AbstractParameter() {

    override fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String> =
        if (parameters.getRedoOcrOrNull() ?: defaultParameters.redoOcr == true) {
            listOf(PARAMETER_REDO_OCR)
        } else {
            emptyList()
        }
}