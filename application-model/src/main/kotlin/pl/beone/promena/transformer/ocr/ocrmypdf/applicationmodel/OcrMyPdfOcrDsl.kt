@file:JvmName("OcrMyPdfOcrDsl")

package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.contract.transformation.singleTransformation
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrConstants.TRANSFORMER_ID
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrConstants.TRANSFORMER_NAME

fun ocrTransformation(targetMediaType: MediaType, parameters: Parameters): Transformation.Single =
    singleTransformation(TRANSFORMER_NAME, targetMediaType, parameters)

fun ocrMyPdfOcrTransformation(targetMediaType: MediaType, parameters: Parameters): Transformation.Single =
    singleTransformation(TRANSFORMER_ID, targetMediaType, parameters)