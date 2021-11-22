# OSS Team Project - Real Time Video Translator

팀 구성원:   
노형준 (juunie-roh)   
박선재 (StandingAsh)   
박준오 (juno801)   
홍록기 (rocky55737)

# 프로젝트 설명

`프로젝트 설명`

# License

[Apache 2.0](LICENSE.md)

# Setting Up

* Real Time Video Translator는 Intellij IDEA 에서, Tesseract 에서 제공하는 JAVA Wrapper 인 [tess4j](https://github.com/nguyenq/tess4j, "tess4j")를 사용합니다.   
[Microsoft Visual C++ 2019 Redestributable](https://visualstudio.microsoft.com/ko/downloads/) 이 설치되어 있는지 확인해주세요.
* Real Time Video Translator는 Intellij IDEA 에서, 파파고에서 제공하는 Papago 번역 API를 사용합니다. Papago 번역 API 사용에 앞서 클라이언트 아이디와 클라이언트 시크릿을 발급받아야합니다.

## Tesseract-OCR
### Installation

* [Windows](README.md#windows) - PRIMARY, Setting up for Devs: 개발 환경 구축하기
* 

#### Windows

For more informations: [Tesseract User Manual](https://tesseract-ocr.github.io/tessdoc/Home.html, "Install tesseract via pre-built binary files")   

> 미리 빌드된 binary 파일로 설치:   
> 1. [Windows - Tesseract at UB Mannheim](https://github.com/UB-Mannheim/tesseract/wiki) 에서 32bit/64bit 선택하여 설치파일을 다운로드, 설치를 진행합니다.   
> 2. [tessdata-best](https://github.com/tesseract-ocr/tessdata_best) 의 파일들을 `zip` 으로 다운받거나 본 repository 에 포함된 tessdata.zip 을 사용합니다.
> 이 repository 에 포함된 tessdata 는 5 가지(chi/eng/jap/kor/spa) 입니다.
> 3. 압축을 해제하여 나온 폴더의 파일들을 tesseract-ocr 내의 tessdata 폴더로 옮겨줍니다.   
>   (기본 설치 경로 `C:₩Program Files₩Tesseract-OCR`)
> 4. 이 repository 의 TesseractExample 폴더를 Intellij IDEA 로 Open 합니다.
> 5. Run 했을 때 command line 으로 사진이 변환된 내용이 출력되면 성공.

## Papago 번역
### Get API Key

* [네이버 개발자 센터](https://developers.naver.com/apps/#/register)에서 로그인 후 애플리케이션을 등록하여 클라이언트 아이디와 클라이언트 시크릿을 발급받을 수 있습니다.

####
> 1. 애플리케이션 이름을 입력합니다. (Ex. RealTimeVideoTranslator)
> 2. 사용 API에서 Papago 번역을 선택합니다.
> 3. 비로그인 오픈 API 서비스 환경에서 WEB 설정을 추가한 후 웹 서비스 URL을 입력합니다. (http://naver.com으로 등록해도 무관)
> 4. 발급받은 Client ID와 Client Secret을 복사 합니다. (Client Secret을 복사할때 하단에 보기버튼을 누른 후 복사해야 합니다.)
> 5. 이 repository 의 PapagoExample 폴더를 Intellij IDEA 로 Open 합니다.
> 6. 21~22번 줄의
> 
>   ```
>     String clientId = "";//애플리케이션 클라이언트 아이디값";
>     String clientSecret = "";//애플리케이션 클라이언트 시크릿값";
>   ```
> 
>    ""안에 복사한 값을 입력한 후 Run 했을 때 번역할 문장을 입력받고, 번역된 문장이 나온다면 성공. (기본은 kor->eng)
