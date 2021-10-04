# OSS Team Project - Real Time Video Translator

Original Tesseract-OCR install documentation: [Build Tesseract From the source code](https://tesseract-ocr.github.io/tessdoc/Compiling.html, "tesseract-ocr man page")

팀 구성원:   
노형준 (juunie-roh)   
박선재 ()   
박준오 ()   
홍록기 ()

# 프로젝트 설명

```프로젝트 설명```

## Tesseract-OCR   
### Installation
* [Linux](README.md#linux)
* [macOS](README.md#macos)

## Linux

### Dependencies
* A compiler for C and C++: GCC or Clang
* GNU Autotools: autoconf, automake, libtool
* pkg-config
* Leptonica
* libpng, libjpeg, libtiff

### Ubuntu

다음과 같은 라이브러리들이 필요합니다(Ubuntu 16.04/14.04):

```bash
sudo apt-get install g++ # or clang++ (presumably)
sudo apt-get install autoconf automake libtool
sudo apt-get install pkg-config
sudo apt-get install libpng-dev
sudo apt-get install libjpeg8-dev
sudo apt-get install libtiff5-dev
sudo apt-get install zlib1g-dev
```

Training tool을 이용하고자 한다면, 아래의 라이브러리들도 필요합니다:

```bash
sudo apt-get install libicu-dev
sudo apt-get install libpango1.0-dev
sudo apt-get install libcairo2-dev
```

### Leptonica

```bash
sudo apt-get install libleptonica-dev
```

### Install elsewhere / without root

Tesseract 는 아무 곳에나 설치할 수 있습니다.   
$HOME/local 의 위치에 설치하려면:

```bash
./autogen.sh
./configure --prefix=$HOME/local/
make
make install
```

몇몇 시스템들에서는
```configure```
명령을 실행하기 전에, 
```pkg-config```
에 대한 경로를 지정해주어야 할 수도 있습니다:

```bash
export PKG_CONFIG_PATH=$HOME/local/lib/pkgconfig
```

### Language Data

Lauguage 학습 데이터가 저장된 경로를 지정해주세요:

```bash
export TESSDATA_PREFIX=/some/path/to/tessdata
```

## macOS

### macOS with Homebrew

```bash
# 필수 패키지들.
brew install automake autoconf libtool
brew install pkgconfig
brew install icu4c
brew install leptonica
# Training Tool 에 필요한 패키지들.
brew install pango
# 추가 기능들을 위한 패키지.
brew install libarchive
# g++ 를 이용해 빌드할 때 필요한 패키지.
brew install gcc
```

### macOS with MacPorts

```bash
# 필수 패키지들.
sudo port install autoconf
sudo port install automake
sudo port install libtool
sudo port install pkgconfig
sudo port install leptonica
# Training Tool 에 필요한 패키지들.
sudo port install cario pango
sudo port install icu +devel 
```

### Compilation

```bash
git clone https://github.com/tesseract-ocr/tesseract.git
cd tesseract
./autogen.sh
./configure
make # 또는 make training (training tool)
sudo make install # 또는 sudo make install training-install
```

### macOS: building for arm-apple-darwin64

애플 실리콘을 사용하는 경우, 다음과 같은 절차가 필요할 수도 있습니다:

```bash
./configure CXX="g++ --target=arm-apple-darwin64"
```


