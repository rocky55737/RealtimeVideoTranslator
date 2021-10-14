# OSS Team Project - Real Time Video Translator

팀 구성원:   
노형준 (juunie-roh)   
박선재 ()   
박준오 (juno801)   
홍록기 (rocky55737)

# 프로젝트 설명

```프로젝트 설명```

# License

[Apache 2.0](LICENSE.md)

# Setting Up

Intellij IDEA 에서, Tesseract 에서 제공하는 JAVA Wrapper 인 [tess4j](https://github.com/nguyenq/tess4j, "tess4j")를 사용합니다.   
[Microsoft Visual C++ 2019 Redestributable](https://visualstudio.microsoft.com/ko/downloads/) 이 설치되어 있는지 확인해주세요.

## Tesseract-OCR
### Installation

* [Windows](README.md#windows) - PRIMARY, Setting up for Devs: 개발 환경 구축하기
* 

## Windows

For more informations: [Tesseract User Manual](https://tesseract-ocr.github.io/tessdoc/Home.html, "Install tesseract via pre-built binary files")   

> 미리 빌드된 binary 파일로 설치:   
> 1. [Windows - Tesseract at UB Mannheim](https://github.com/UB-Mannheim/tesseract/wiki) 에서 32bit/64bit 선택하여 설치파일을 다운로드, 설치를 진행합니다.   
> 2. [tessdata-best](https://github.com/tesseract-ocr/tessdata_best) 의 파일들을 ```zip``` 으로 다운받거나 본 repository 에 포함된 tessdata.zip 을 사용합니다.
>   > 이 repository 에 포함된 tessdata 는 5 가지(chi/eng/jap/kor/spa) 입니다.
> 3. 압축을 해제하여 나온 폴더의 파일들을 tesseract-ocr 내의 tessdata 폴더로 옮겨줍니다.   
>   (기본 설치 경로 ```C:₩Program Files₩Tesseract-OCR```)
> 4. 이 repository 의 TesseractExample 폴더를 Intellij IDEA 로 Open 합니다.
> 5. Run 했을 때 command line 으로 사진이 변환된 내용이 출력되면 성공.

