# OSS Team Project - Real Time Video Translator

팀 구성원:   
노형준 (juunie-roh)   
박선재 ()   
박준오 ()   
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

* [Windows](README.md#windows) - PRIMARY

## Windows

For more informations: [Tesseract User Manual](https://tesseract-ocr.github.io/tessdoc/Home.html, "Install tesseract via pre-built binary files")   

미리 빌드된 binary 파일로 설치합니다.
1. [Windows - Tesseract at UB Mannheim](https://github.com/UB-Mannheim/tesseract/wiki) 에서 32bit/64bit 선택하여 설치파일을 다운로드, 설치를 진행합니다.   
2. [tessdata-best](https://github.com/tesseract-ocr/tessdata_best) 에서 미리 학습된 데이터들을 ```.zip``` 으로 받아 압축을 풀어줍니다.   
3. 압축을 해제하여 나온 폴더의 파일들을 tesseract-ocr 내의 tessdata 폴더로 옮겨줍니다. (Default path is, C:₩Program Files₩Tesseract-OCR)
4. Intellij IDEA 를 실행하여 새 프로젝트를 생성합니다.

