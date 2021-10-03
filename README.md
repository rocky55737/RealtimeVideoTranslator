# Open Source Software - Team Project

## Linux

### Dependencies
* A compiler for C and C++: GCC or Clang
* GNU Autotools: autoconf, automake, libtool
* pkg-config
* Leptonica
* libpng, libjpeg, libtiff

### Ubuntu

You will need following libraries (Ubuntu 16.04/14.04):

```bash
sudo apt-get install g++ # or clang++ (presumably)
sudo apt-get install autoconf automake libtool
sudo apt-get install pkg-config
sudo apt-get install libpng-dev
sudo apt-get install libjpeg8-dev
sudo apt-get install libtiff5-dev
sudo apt-get install zlib1g-dev
```

if you plan to install the training tools, you also need the following libraries:

```bash
sudo apt-get install libicu-dev
sudo apt-get install libpango1.0-dev
sudo apt-get install libcairo2-dev
```

### Leptonica

```bash
sudo apt-get install libleptonica-dev
```


