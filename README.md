# OSS Team Project - Real Time Video Translator

팀 구성원:   
노형준 (juunie-roh)   
박선재 (StandingAsh)   
박준오 (juno801)   
홍록기 (rocky55737)

## 프로젝트 설명

이 프로젝트는 사용자가 선택한 영역을 Tesseract-OCR 로 모니터링하여 인식한 문자를 GUI 로 출력합니다.   

# License

[Apache 2.0](LICENSE.md)

# Setting Up

* Real Time Video Translator는 Intellij IDEA 에서, Tesseract 에서 제공하는 JAVA Wrapper 인 [tess4j](https://github.com/nguyenq/tess4j, "tess4j")를 사용합니다.   
[Microsoft Visual C++ 2019 Redestributable](https://visualstudio.microsoft.com/ko/downloads/) 이 설치되어 있는지 확인해주세요.
* 이 프로젝트는 JDK 1.8 | Lanuage level 8 을 사용합니다.
* Real Time Video Translator는 Intellij IDEA 에서, 파파고에서 제공하는 Papago 번역 API를 사용합니다. Papago 번역 API 사용에 앞서 클라이언트 아이디와 클라이언트 시크릿을 발급받아야 합니다.

## Tesseract-OCR
### Installation
#### For Users
* [Windows - Tesseract at UB Mannheim](https://github.com/UB-Mannheim/tesseract/wiki) 에서 32bit/64bit 선택하여 설치해주세요.
* [Java](https://java.com/) .jar 실행 파일을 사용하므로 Java 가 필요합니다. (javac ver 1.8.x)
* 위의 두 단계가 완료되면 이 repository 의 RTVT.exe 를 실행해주세요!
#### For Devs
* [Windows](README.md#windows) - Tesseract-OCR 설치 및 tessdata 설정
* [Papago](README.md#papago-) - Papago Open API Set up

### Windows

For more information: [Tesseract User Manual](https://tesseract-ocr.github.io/tessdoc/Home.html, "Install tesseract via pre-built binary files")   

> 미리 빌드된 binary 파일로 설치:   
> 1. [Windows - Tesseract at UB Mannheim](https://github.com/UB-Mannheim/tesseract/wiki) 에서 32bit/64bit 선택하여 설치파일을 다운로드, 설치를 진행합니다.   
> 2. [tessdata-best](https://github.com/tesseract-ocr/tessdata_best) 의 파일들을 다운 받아 저장합니다. 
> 3. tesseract-ocr 을 독립적으로 활용하고 싶다면 다운로드한 tessdata 들을 설치된 경로 하위의 tessdata 폴더로 옮겨주는 것이 좋습니다. 
> 이 프로젝트에서는 repository 에 포함된 tessdata 폴더를 사용합니다.     
> (기본 설치 경로 `C:₩Program Files₩Tesseract-OCR`)
> 4. 이 repository 를 Intellij IDEA 로 열고, project-structure - Libraries 에 lib 폴더를 추가합니다.   
> tess4j library 는 Maven Repository 를 통해서 받을 수도 있습니다. (net.sourceforge.tess4j 검색)
> 5. Event Log 를 무시하고 빌드해도 정상적으로 빌드된다면 잘 세팅된 것입니다.

## Papago 번역
### Get API Key

* [네이버 개발자 센터](https://developers.naver.com/apps/#/register)에서 로그인 후 애플리케이션을 등록하여 클라이언트 아이디와 클라이언트 시크릿을 발급받을 수 있습니다.
* 해당 번역 API 는 일일 횟수 제한이 있습니다.

> 1. 애플리케이션 이름을 입력합니다. (Ex. RealTimeVideoTranslator)
> 2. 사용 API에서 Papago 번역을 선택합니다.
> 3. 비로그인 오픈 API 서비스 환경에서 WEB 설정을 추가한 후 웹 서비스 URL을 입력합니다. (http://naver.com으로 등록해도 무관)
> 4. 발급받은 Client ID와 Client Secret을 복사 합니다. (Client Secret을 복사할때 하단에 보기버튼을 누른 후 복사해야 합니다.)
> 5. `translator/main/src/org/realtimetranslator/translator/PapagoTranslator.java` 파일의 16, 17번 째 줄:
> 
>   ```
>     private static final String clientId = "";//애플리케이션 클라이언트 아이디값";
>     private static final String clientSecret = "";//애플리케이션 클라이언트 시크릿값";
>   ```
> 
>    ""안에 복사한 값을 입력한 후 Run 했을 때 번역할 문장을 입력받고, 번역된 문장이 나온다면 성공. (기본은 kor->eng)
