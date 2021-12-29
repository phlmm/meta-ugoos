require kodi-vers.inc
BRANCH="master"
KODINAME = "${KODICODENAME}"
KODIVER = "20.0"
KODIURI = "git://github.com/xbmc/xbmc.git;protocol=https;branch=${BRANCH}"
KODIWORKDIR ?= "${WORKDIR}/git"

KODIPATCHES ?= ""
KODIADDONS ?= ""

inherit pkgconfig cmake gettext python3-dir python3native kodi-common

SRC_URI = "${KODIURI} \
           file://0001-FindLibDvd.cmake-fix-logic-for-reusing-system-librar.patch \
           "
SRCREV = "${AUTOREV}"
S = "${KODIWORKDIR}"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM ?= "file:///${WORKDIR}/git/LICENSE.md;md5=7b423f1c9388eae123332e372451a4f7"
PACKAGECONFIG:append = " mysql gbm systemd bluetooth pulseaudio"
PACKAGECONFIG:remove = " optical vaapi vdpau xa airtunes"
EXTRA_OECMAKE:append = " -DENABLE_CCACHE=0 -DVERBOSE=1"


DEPENDS += " \
  gnutls \
  dav1d \
  ccache-native \
  mdns \
  swig-native \
  libnss-mdns \
  virtual/egl \
  harfbuzz \
  curl-native \
  flatbuffers-native \
  googletest-native \
  gperf-native \
  kodi-tools-jsonschemabuilder-native \
  kodi-tools-texturepacker-native \
  nasm-native \
  unzip-native \
  yasm-native \
  zip-native \
  avahi \
  boost \
  bzip2 \
  crossguid \
  curl \
  dcadec \
  enca \
  expat \
  faad2 \
  ffmpeg \
  flatbuffers \
  fmt \
  netcat \
  libunistring \
  fontconfig \
  fribidi \
  fstrcmp \
  giflib \
  libass \
  libcdio \
  libcec \
  libdvdread \
  libdvdcss \
  libdvdnav \
  libinput \
  libmad \
  libmicrohttpd \
  libmms \
  libmodplug \
  libnfs \
  libpcre \
  libplist \
  libsamplerate0 \
  libsquish \
  libssh \
  bzip2 \
  lzo \
  libtinyxml \
  libusb1 \
  libxkbcommon \
  libxslt \
  lzo \
  mpeg2dec \
  python3 \
  rapidjson \
  spdlog \
  sqlite3 \
  taglib \
  udev \
  wavpack \
  yajl \
  zlib \
"
RRECOMMENDS:${PN}:append:libc-glibc = " \
  glibc-gconv-cp1252 \
  glibc-gconv-cp1251 \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILES:${PN} += "${datadir}/metainfo"
