package pl.beone.promena.transformer.ocr.ocrmypdf

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel.ocrMyPdfOcrParameters
import pl.beone.promena.transformer.ocr.ocrmypdf.model.Resource.Document.CEIDG
import pl.beone.promena.transformer.ocr.ocrmypdf.util.pdfTest
import pl.beone.promena.transformer.ocr.ocrmypdf.util.textTest

@ExtendWith(DockerExtension::class)
class OcrMyPdfOcrTransformerTest {

    companion object {
        private val assertStrings = listOf(
            "CEIDG-1 WNIOSEK O WPIS DO CENTRALNEJ EWIDENCJI I INFORMACJI",
            "O DZIAŁALNOŚCI GOSPODARCZEJ",
            "wniosek o wykreślenie przedsiębiorcy z CEIDG.",
            "02. Miejsce i data złożenia wniosku: (wypełnia urząd)",
            "02.2. Data złożenia wniosku:",
            "(RRRR-MM-DD)",
            "03. Dane wnioskodawcy:",
            "2a. Rodzaj dokumentu tożsamości*:",
            "6. Nazwisko*:",
            "7. Imię pierwsze*:",
            "8. Nazwisko rodowe: 9. Imię drugie:",
            "(o ile posiada)",
            "10. Imię ojca*: 11. Imię matki*:",
            "- tak, składam oświadczenie",
            "03.2. Dane dokumentu potwierdzającego status cudzoziemca:",
            "04. Adres zamieszkania wnioskodawcy*:",
            "1. Adres elektroniczny:",
            "2. Rezygnacja z adresu elektronicznego",
            "CEIDG-1 (wersja 1.8.8)",
            "Strona 1z5",
            "CEIDG-1"
        )
    }

    @Test
    fun transform_applicationPdf_defaultParameters() {
        pdfTest(CEIDG, assertStrings)
    }

    @Test
    fun transform_textPlain_defaultParameters() {
        textTest(CEIDG, assertStrings)
    }

    @Test
    fun transform_applicationPdf_allPossibleParameters() {
        pdfTest(
            CEIDG,
            assertStrings,
            ocrMyPdfOcrParameters(
                pdfRenderer = "sandwich",
                rotatePages = true,
                rotatePagesThreshold = 1.111f,
                removeBackground = false, // if it is 'true', it destroys special characters for example '*'
                optimize = 1,
                oversample = 300,
                redoOcr = false, // --redo-ocr is not currently compatible with --deskew, --clean-final, and --remove-background
                forceOcr = true,
                deskew = true,
                skipText = false, // choose only one of --force-ocr, --skip-text, --redo-ocr
                clean = true,
                cleanFinal = true,
                skipBig = 50.111f,
                unpaperArgs = "--no-noisefilter",
                tesseractTimeout = 60
            )
        )
    }
}