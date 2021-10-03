# Open Source Software - Team Project

Original Tesseract-OCR Man page: [Build Tesseract From the source code](https://tesseract-ocr.github.io/tessdoc/Compiling.html)

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


