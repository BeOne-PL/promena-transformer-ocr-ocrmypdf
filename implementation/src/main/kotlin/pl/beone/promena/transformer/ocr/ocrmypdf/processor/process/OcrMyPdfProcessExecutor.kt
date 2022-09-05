package pl.beone.promena.transformer.ocr.ocrmypdf.processor.process

import mu.KotlinLogging
import pl.beone.promena.transformer.ocr.ocrmypdf.processor.process.OcrMyPdfProcessParameterConstants.COMMAND
import java.io.InputStream

object OcrMyPdfProcessExecutor {

    private val logger = KotlinLogging.logger {}

    fun execute(parameters: List<String>): InputStream {
        val command = listOf(COMMAND) + parameters

        logger.debug { "Executing command: $command" }

        val process = ProcessBuilder(command)
            .start()

        if (process.waitFor() != 0) {
            val errorMessage = process.errorStream.readString()
            process.destroy()
            throw RuntimeException(errorMessage)
        }

        return process.inputStream
    }

    private fun InputStream.readString(): String =
        String(readBytes())
}