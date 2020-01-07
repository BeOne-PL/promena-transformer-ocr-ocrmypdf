package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import pl.beone.lib.typeconverter.applicationmodel.exception.TypeConversionException
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.Clean
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.CleanFinal
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.Deskew
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.ForceOcr
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.Language
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.Optimize
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.Oversample
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.PdfRenderer
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.RedoOcr
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.RemoveBackground
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.RotatePages
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.RotatePagesThreshold
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.SkipBig
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.SkipText
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.TesseractTimeout
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.OcrMyPdfOcrParametersConstants.UnpaperArgs

object OcrMyPdfOcrSupport {

    @JvmStatic
    fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters) {
        dataDescriptor.descriptors.forEach { (_, mediaType) -> MediaTypeSupport.isSupported(mediaType, targetMediaType) }
        ParametersSupport.isSupported(parameters)
    }

    object MediaTypeSupport {
        private val supportedMediaType = setOf(
            APPLICATION_PDF to APPLICATION_PDF,
            APPLICATION_PDF to TEXT_PLAIN
        )

        @JvmStatic
        fun isSupported(mediaType: MediaType, targetMediaType: MediaType) {
            if (!supportedMediaType.contains(mediaType to targetMediaType)) {
                throw TransformationNotSupportedException.unsupportedMediaType(mediaType, targetMediaType)
            }
        }
    }

    object ParametersSupport {
        @JvmStatic
        fun isSupported(parameters: Parameters) {
            parameters.validate(Language.NAME, Language.CLASS, false)
            with(OcrMyPdfOcrPdfRenderer.values().map(OcrMyPdfOcrPdfRenderer::value)) {
                parameters.validate(PdfRenderer.NAME, PdfRenderer.CLASS, false, "(${joinToString(", ")})")
                { contains(it) }
            }
            parameters.validate(RotatePages.NAME, RotatePages.CLASS, false)
            parameters.validate(RotatePagesThreshold.NAME, RotatePagesThreshold.CLASS, false, "<0.0, 1000.0>")
            { (0.0..1000.0).contains(it) }
            parameters.validate(RemoveBackground.NAME, RemoveBackground.CLASS, false)
            parameters.validate(Optimize.NAME, Optimize.CLASS, false, "(0, 1, 2, 3)")
            { listOf(0, 1, 2, 3).contains(it) }
            parameters.validate(Oversample.NAME, Oversample.CLASS, false, "<0, 5000>")
            { (0..5000).contains(it) }
            parameters.validate(RedoOcr.NAME, RedoOcr.CLASS, false)
            parameters.validate(ForceOcr.NAME, ForceOcr.CLASS, false)
            parameters.validate(Deskew.NAME, Deskew.CLASS, false)
            parameters.validate(SkipText.NAME, SkipText.CLASS, false)
            parameters.validate(Clean.NAME, Clean.CLASS, false)
            parameters.validate(CleanFinal.NAME, CleanFinal.CLASS, false)
            parameters.validate(SkipBig.NAME, SkipBig.CLASS, false, "<0.0, 5000.0>")
            { (0.0..5000.0).contains(it) }
            parameters.validate(UnpaperArgs.NAME, UnpaperArgs.CLASS, false)
            parameters.validate(TesseractTimeout.NAME, TesseractTimeout.CLASS, false)

            if (parameters.isSetAndTrue(RedoOcr.NAME) && parameters.atLeastIsSetAndTrue(1, Deskew.NAME, CleanFinal.NAME, RemoveBackground.NAME)) {
                throw TransformationNotSupportedException.custom("Parameter <${RedoOcr.NAME}> isn't compatible with <${Deskew.NAME}, ${CleanFinal.NAME}, ${RemoveBackground.NAME}>")
            }

            if (parameters.getOrNull(UnpaperArgs.NAME) != null && !parameters.isSetAndTrue(Clean.NAME)) {
                throw TransformationNotSupportedException.custom("Parameter <${UnpaperArgs.NAME}> requires <${Clean.NAME}>")
            }

            if (parameters.atLeastIsSetAndTrue(2, ForceOcr.NAME, SkipText.NAME, RedoOcr.NAME)) {
                throw TransformationNotSupportedException.custom("Only one of <${ForceOcr.NAME}, ${SkipText.NAME}, ${RedoOcr.NAME}> is allowed")
            }
        }

        private fun <T> Parameters.validate(
            name: String,
            clazz: Class<T>,
            mandatory: Boolean,
            valueVerifierMessage: String? = null,
            valueVerifier: (T) -> Boolean = { true }
        ) {
            try {
                val value = get(name, clazz)
                if (!valueVerifier(value)) {
                    throw TransformationNotSupportedException.unsupportedParameterValue(name, value, valueVerifierMessage)
                }
            } catch (e: NoSuchElementException) {
                if (mandatory) {
                    throw TransformationNotSupportedException.mandatoryParameter(name)
                }
            } catch (e: TypeConversionException) {
                throw TransformationNotSupportedException.unsupportedParameterType(name, clazz)
            }
        }

        private fun Parameters.isSetAndTrue(name: String): Boolean =
            getOrNull(name) == true

        private fun Parameters.atLeastIsSetAndTrue(atLeast: Int, vararg names: String): Boolean =
            names.mapNotNull { getOrNull(it) }
                .map { it as Boolean }
                .filter { it }
                .count() >= atLeast
    }
}