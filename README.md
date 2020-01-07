# Promena Transformer - `ocr - OCRmyPDF`
This transformer provides functionality to OCR a document using OCRmyPDF 9.3.0.

Visit [Promena#Transformers](https://gitlab.office.beone.pl/promena/promena#transformers) to understand the repository structure.

## Transformation [`OcrMyPdfOcrDsl`](./application-model/src/main/kotlin/pl/beone/promena/transformer/ocr/ocrmypdf/applicationmodel/OcrMyPdfOcrDsl.kt), [`OcrMyPdfOcrParametersDsl`](./application-model/src/main/kotlin/pl/beone/promena/transformer/ocr/ocrmypdf/applicationmodel/OcrMyPdfOcrParametersDsl.kt)
The [`DataDescriptor`](https://gitlab.office.beone.pl/promena/promena/blob/master/base/promena-transformer/contract/src/main/kotlin/pl/beone/promena/transformer/contract/data/DataDescriptor.kt) has to contain at least one descriptor. If more than one descriptor is passed, the transformation will be performed on each of them separately.

## Support [`OcrMyPdfOcrSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/ocr/ocrmypdf/applicationmodel/OcrMyPdfOcrSupport.kt)
### Media type [`OcrMyPdfOcrSupport.MediaTypeSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/ocr/ocrmypdf/applicationmodel/OcrMyPdfOcrSupport.kt)
* `application/pdf; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/pdf; UTF-8` :arrow_right: `text/plain; UTF-8`

### Parameters [`OcrMyPdfOcrSupport.ParametersSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/ocr/ocrmypdf/applicationmodel/OcrMyPdfOcrSupport.kt)
The explanation of each parameter is described in [OCRmyPDF documentation](https://ocrmypdf.readthedocs.io/en/v9.3.0/).
* `language`, `String`, optional
* `pdfRenderer`, `String`, *`["auto", "hocr", "sandwich"]`*, optional
* `rotatePages`, `Boolean`, optional
* `rotatePagesThreshold`, `Float`, *`<0.0, 1000.0>`*, optional
* `removeBackground`, `Boolean`, optional
* `optimize`, `Boolean`, *`(0, 1, 2, 3)`*, optional
* `oversample`, `Int`, *`<0, 5000>`*, optional
* `redoOcr`, `Boolean`, optional
* `forceOcr`, `Boolean`, optional
* `deskew`, `Boolean`, optional
* `skipText`, `Boolean`, optional
* `clean`, `Boolean`, optional
* `cleanFinal`, `Boolean`, optional
* `skipBig`, `Float`, *`<0.0, 5000.0>`*, optional
* `unpaperArgs`, `String`, optional
* `tesseractTimeout`, `Int`, optional
    * `redoOcr` isn't compatible with (`deskew`, `cleanFinal`, `removeBackground`)
    * `unpaperArgs` requires `clean`
    * Only one of (`forceOcr`, `skipText`, `redoOcr`) is allowed

## Dependency
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>ocr-ocrmypdf-configuration</artifactId>
    <version>1.0.0</version>
</dependency>
```

### `promena-docker-maven-plugin`
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>ocr-ocrmypdf</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Properties
```properties
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformer.priority=1
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.OcrMyPdfOcrTransformer.actors=1

transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.language=pol+eng
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.pdf-renderer=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.rotate-pages-threshold=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.remove-background=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.optimize=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.oversample=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.redo-ocr=
# Force OCR if page contains both text and images
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.force-ocr=true
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.deskew=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-text=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.clean-final=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.skip-big=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.unpaper-args=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.tesseract-timeout=
transformer.pl.beone.promena.transformer.ocr.ocrmypdf.default.parameters.timeout=
```