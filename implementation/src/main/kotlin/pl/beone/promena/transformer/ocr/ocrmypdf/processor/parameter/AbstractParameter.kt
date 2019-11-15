package pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters

abstract class AbstractParameter {

    abstract fun create(parameters: Parameters, defaultParameters: OcrMyPdfOcrTransformerDefaultParameters): List<String>

    protected fun <T> eitherNotNullValueOrEmptyList(parameter: String, vararg values: T?, process: (String) -> String = { it }): List<String> {
        val value = values.firstOrNull { it != null }
        return if (value != null) {
            listOf(parameter, process(value.toString()))
        } else {
            emptyList()
        }
    }
}