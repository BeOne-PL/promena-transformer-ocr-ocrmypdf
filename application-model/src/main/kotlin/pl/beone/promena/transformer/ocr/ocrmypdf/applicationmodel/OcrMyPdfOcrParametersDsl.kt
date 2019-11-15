@file:JvmName("OcrMyPdfOcrParametersDsl")

package pl.beone.promena.transformer.ocr.ocrmypdf.applicationmodel

import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.internal.model.parameters.MapParameters
import pl.beone.promena.transformer.internal.model.parameters.addIfNotNull
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters
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

fun ocrMyPdfOcrParameters(
    language: String? = null,
    pdfRenderer: String? = null,
    rotatePages: Boolean? = null,
    rotatePagesThreshold: Float? = null,
    removeBackground: Boolean? = null,
    optimize: Int? = null,
    oversample: Int? = null,
    redoOcr: Boolean? = null,
    forceOcr: Boolean? = null,
    deskew: Boolean? = null,
    skipText: Boolean? = null,
    clean: Boolean? = null,
    cleanFinal: Boolean? = null,
    skipBig: Float? = null,
    unpaperArgs: String? = null,
    tesseractTimeout: Int? = null
): MapParameters =
    emptyParameters() addIfNotNull
            (Language.NAME to language) addIfNotNull
            (PdfRenderer.NAME to pdfRenderer) addIfNotNull
            (RotatePages.NAME to rotatePages) addIfNotNull
            (RotatePagesThreshold.NAME to rotatePagesThreshold) addIfNotNull
            (RemoveBackground.NAME to removeBackground) addIfNotNull
            (Optimize.NAME to optimize) addIfNotNull
            (Oversample.NAME to oversample) addIfNotNull
            (RedoOcr.NAME to redoOcr) addIfNotNull
            (ForceOcr.NAME to forceOcr) addIfNotNull
            (Deskew.NAME to deskew) addIfNotNull
            (SkipText.NAME to skipText) addIfNotNull
            (Clean.NAME to clean) addIfNotNull
            (CleanFinal.NAME to cleanFinal) addIfNotNull
            (SkipBig.NAME to skipBig) addIfNotNull
            (UnpaperArgs.NAME to unpaperArgs) addIfNotNull
            (TesseractTimeout.NAME to tesseractTimeout)

fun Parameters.getLanguage(): String =
    get(Language.NAME, Language.CLASS)

fun Parameters.getLanguageOrNull(): String? =
    getOrNull(Language.NAME, Language.CLASS)

fun Parameters.getLanguageOrDefault(default: String): String =
    getOrDefault(Language.NAME, Language.CLASS, default)

fun Parameters.getRotatePages(): Boolean =
    get(RotatePages.NAME, RotatePages.CLASS)

fun Parameters.getRotatePagesOrNull(): Boolean? =
    getOrNull(RotatePages.NAME, RotatePages.CLASS)

fun Parameters.getRotatePagesOrDefault(default: Boolean): Boolean =
    getOrDefault(RotatePages.NAME, RotatePages.CLASS, default)

fun Parameters.getPdfRenderer(): String =
    get(PdfRenderer.NAME, PdfRenderer.CLASS)

fun Parameters.getPdfRendererOrNull(): String? =
    getOrNull(PdfRenderer.NAME, PdfRenderer.CLASS)

fun Parameters.getPdfRendererOrDefault(default: String): String =
    getOrDefault(PdfRenderer.NAME, PdfRenderer.CLASS, default)

fun Parameters.getRotatePagesThreshold(): Float =
    get(RotatePagesThreshold.NAME, RotatePagesThreshold.CLASS)

fun Parameters.getRotatePagesThresholdOrNull(): Float? =
    getOrNull(RotatePagesThreshold.NAME, RotatePagesThreshold.CLASS)

fun Parameters.getRotatePagesThresholdOrDefault(default: Float): Float =
    getOrDefault(RotatePagesThreshold.NAME, RotatePagesThreshold.CLASS, default)

fun Parameters.getRemoveBackground(): Boolean =
    get(RemoveBackground.NAME, RemoveBackground.CLASS)

fun Parameters.getRemoveBackgroundOrNull(): Boolean? =
    getOrNull(RemoveBackground.NAME, RemoveBackground.CLASS)

fun Parameters.getRemoveBackgroundOrDefault(default: Boolean): Boolean =
    getOrDefault(RemoveBackground.NAME, RemoveBackground.CLASS, default)

fun Parameters.getOptimize(): Int =
    get(Optimize.NAME, Optimize.CLASS)

fun Parameters.getOptimizeOrNull(): Int? =
    getOrNull(Optimize.NAME, Optimize.CLASS)

fun Parameters.getOptimizeOrDefault(default: Int): Int =
    getOrDefault(Optimize.NAME, Optimize.CLASS, default)

fun Parameters.getOversample(): Int =
    get(Oversample.NAME, Oversample.CLASS)

fun Parameters.getOversampleOrNull(): Int? =
    getOrNull(Oversample.NAME, Oversample.CLASS)

fun Parameters.getOversampleOrDefault(default: Int): Int =
    getOrDefault(Oversample.NAME, Oversample.CLASS, default)

fun Parameters.getRedoOcr(): Boolean =
    get(RedoOcr.NAME, RedoOcr.CLASS)

fun Parameters.getRedoOcrOrNull(): Boolean? =
    getOrNull(RedoOcr.NAME, RedoOcr.CLASS)

fun Parameters.getRedoOcrOrDefault(default: Boolean): Boolean =
    getOrDefault(RedoOcr.NAME, RedoOcr.CLASS, default)

fun Parameters.getForceOcr(): Boolean =
    get(ForceOcr.NAME, ForceOcr.CLASS)

fun Parameters.getForceOcrOrNull(): Boolean? =
    getOrNull(ForceOcr.NAME, ForceOcr.CLASS)

fun Parameters.getForceOcrOrDefault(default: Boolean): Boolean =
    getOrDefault(ForceOcr.NAME, ForceOcr.CLASS, default)

fun Parameters.getDeskew(): Boolean =
    get(Deskew.NAME, Deskew.CLASS)

fun Parameters.getDeskewOrNull(): Boolean? =
    getOrNull(Deskew.NAME, Deskew.CLASS)

fun Parameters.getDeskewOrDefault(default: Boolean): Boolean =
    getOrDefault(Deskew.NAME, Deskew.CLASS, default)

fun Parameters.getSkipText(): Boolean =
    get(SkipText.NAME, SkipText.CLASS)

fun Parameters.getSkipTextOrNull(): Boolean? =
    getOrNull(SkipText.NAME, SkipText.CLASS)

fun Parameters.getSkipTextOrDefault(default: Boolean): Boolean =
    getOrDefault(SkipText.NAME, SkipText.CLASS, default)

fun Parameters.getClean(): Boolean =
    get(Clean.NAME, Clean.CLASS)

fun Parameters.getCleanOrNull(): Boolean? =
    getOrNull(Clean.NAME, Clean.CLASS)

fun Parameters.getCleanOrDefault(default: Boolean): Boolean =
    getOrDefault(Clean.NAME, Clean.CLASS, default)

fun Parameters.getCleanFinal(): Boolean =
    get(CleanFinal.NAME, CleanFinal.CLASS)

fun Parameters.getCleanFinalOrNull(): Boolean? =
    getOrNull(CleanFinal.NAME, CleanFinal.CLASS)

fun Parameters.getCleanFinalOrDefault(default: Boolean): Boolean =
    getOrDefault(CleanFinal.NAME, CleanFinal.CLASS, default)

fun Parameters.getSkipBig(): Float =
    get(SkipBig.NAME, SkipBig.CLASS)

fun Parameters.getSkipBigOrNull(): Float? =
    getOrNull(SkipBig.NAME, SkipBig.CLASS)

fun Parameters.getSkipBigOrDefault(default: Float): Float =
    getOrDefault(SkipBig.NAME, SkipBig.CLASS, default)

fun Parameters.getUnpaperArgs(): String =
    get(UnpaperArgs.NAME, UnpaperArgs.CLASS)

fun Parameters.getUnpaperArgsOrNull(): String? =
    getOrNull(UnpaperArgs.NAME, UnpaperArgs.CLASS)

fun Parameters.getUnpaperArgsOrDefault(default: String): String =
    getOrDefault(UnpaperArgs.NAME, UnpaperArgs.CLASS, default)

fun Parameters.getTesseractTimeout(): Int =
    get(TesseractTimeout.NAME, TesseractTimeout.CLASS)

fun Parameters.getTesseractTimeoutOrNull(): Int? =
    getOrNull(TesseractTimeout.NAME, TesseractTimeout.CLASS)

fun Parameters.getTesseractTimeoutOrDefault(default: Int): Int =
    getOrDefault(TesseractTimeout.NAME, TesseractTimeout.CLASS, default)