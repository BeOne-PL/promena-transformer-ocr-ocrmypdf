package pl.beone.promena.transformer.ocr.ocrmypdf.example

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrTransformation

fun `promena _ pdf _ polish ceidg document`(): Transformation {
    // Data: ceidg.pdf

    return ocrMyPdfOcrTransformation(APPLICATION_PDF, ocrMyPdfOcrParameters(language = "pol+eng"))
}

fun `promena _ text _ polish ceidg document`(): Transformation {
    // Data: ceidg.pdf

    return ocrMyPdfOcrTransformation(TEXT_PLAIN, ocrMyPdfOcrParameters(language = "pol+eng"))
}