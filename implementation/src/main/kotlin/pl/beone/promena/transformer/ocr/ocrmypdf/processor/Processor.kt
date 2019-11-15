package pl.beone.promena.transformer.ocr.ocrmypdf.processor

import kotlinx.coroutines.asCoroutineDispatcher
import mu.KotlinLogging
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.contract.model.data.WritableData
import pl.beone.promena.transformer.internal.extension.copy
import pl.beone.promena.transformer.internal.model.data.file.FileData
import pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformerDefaultParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.parameter.*
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessExecutor
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.PARAMETER_SIDECAR
import pl.beone.promena.transformer.util.execute
import java.io.File
import java.util.concurrent.Executors

internal class Processor(
    private val defaultParameters: OcrMyPdfOcrTransformerDefaultParameters
) {

    companion object {
        private val logger = KotlinLogging.logger {}

        private val processParameters = listOf(
            QuietParameter,
            LanguageParameter,
            PdfRendererParameter,
            RotatePagesParameter,
            RotatePagesThresholdParameter,
            RemoveBackgroundParameter,
            OptimizeParameter,
            OversampleParameter,
            RedoOcrParameter,
            ForceOcrParameter,
            DeskewParameter,
            SkipTextParameter,
            CleanParameter,
            CleanFinalParameter,
            SkipBigParameter,
            UnpaperArgsParameter,
            TesseractTimeoutParameter
        )
    }

    private val executionDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    fun process(
        singleDataDescriptor: DataDescriptor.Single,
        targetMediaType: MediaType,
        parameters: Parameters,
        transformedWritableData: WritableData
    ): TransformedDataDescriptor.Single {
        val (data, _, metadata) = singleDataDescriptor

        execute(parameters.getTimeoutOrNull() ?: defaultParameters.timeout, executionDispatcher) {
            val sourceFile = createFileIfDataImplementationDoesNotEqualFileData(data)
            val processParameters = determineProcessParameters(parameters) + sourceFile.path

            try {
                when (targetMediaType) {
                    APPLICATION_PDF -> processApplicationPdf(processParameters, transformedWritableData)
                    TEXT_PLAIN -> processPlainText(processParameters, transformedWritableData)
                    else -> IllegalStateException("It is validated earlier. It's impossible")
                }
            } finally {
                sourceFile.delete()
            }
        }

        return singleTransformedDataDescriptor(transformedWritableData, metadata)
    }

    private fun createFileIfDataImplementationDoesNotEqualFileData(data: Data): File =
        if (data is FileData) {
            File(data.getLocation())
        } else {
            logger.debug { "Data implementation doesn't equal <FileData>. Creating and saving to temp file..." }
            createTempPdfFile().also { copyToFile(data, it) }
        }

    private fun determineProcessParameters(parameters: Parameters): List<String> =
        processParameters.fold(emptyList()) { acc, parameter -> acc + parameter.create(parameters, defaultParameters) }

    private fun processApplicationPdf(processParameters: List<String>, transformedWritableData: WritableData) {
        val targetFile = createTempPdfFile()
        try {
            OcrMyPdfProcessExecutor.execute(processParameters + targetFile.path)
            transformedWritableData.copy(targetFile.inputStream())
        } finally {
            targetFile.delete()
        }
    }

    private fun processPlainText(processParameters: List<String>, transformedWritableData: WritableData) {
        val targetTmpFile = createTempPdfFile()
        val sidecarFile = createTempPdfFile()
        try {
            OcrMyPdfProcessExecutor.execute(processParameters + listOf(PARAMETER_SIDECAR, sidecarFile.path) + targetTmpFile.path)
            transformedWritableData.copy(sidecarFile.inputStream())
        } finally {
            targetTmpFile.delete()
            sidecarFile.delete()
        }
    }

    private fun createTempPdfFile(): File =
        createTempFile(suffix = ".pdf")

    private fun copyToFile(data: Data, file: File) {
        data.getInputStream().use { inputStream -> file.outputStream().use { inputStream.copyTo(it) } }
    }
}