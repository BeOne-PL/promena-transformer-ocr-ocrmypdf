package pl.beone.promena.transformer.ocr.ocrmypdf

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.internal.model.data.file.toFileData
import pl.beone.promena.transformer.ocr.ocrmypdf.model.Resource.Document.HELLO_WORLD
import pl.beone.promena.transformer.ocr.ocrmypdf.util.textTest

@ExtendWith(DockerExtension::class)
class OcrMyPdfOcrTransformerCommunicationTest {

    @Test
    fun transform_plainText_defaultParametersAndFileData() {
        val file = createTempFile()
        try {
            textTest(HELLO_WORLD, listOf("Hello World!")) {
                file.writeBytes(it)
                file.toFileData()
            }
        } finally {
            file.deleteRecursively()
        }
    }
}