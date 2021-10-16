BRANCH="Matrix"
KODIURI = "git://github.com/xbmc/xbmc.git;protocol=https;branch=${BRANCH}"
#KODIREV ?= "${KODIVER}-${KODICODENAME}"
KODIWORKDIR ?= "${WORKDIR}/git"

KODIPATCHES ?= ""
KODIADDONS ?= ""

SRC_URI = "${KODIURI}"
SRCREV = "${AUTOREV}"
S = "${KODIWORKDIR}"


LICENSE = "GPLv2"
LIC_FILES_CHKSUM ?= "file:///${WORKDIR}/git/LICENSE.md;md5=7b423f1c9388eae123332e372451a4f7"
PACKAGECONFIG:append:ugoos-am6 = " gbm systemd bluetooth pulseaudio"
PACKAGECONFIG:remove:ugoos-am6 = " optical vaapi vdpau xa airtunes "

#EXTRA_OECMAKE:append = " --enable-cross-compile"
#DEPENDS:remove:ugoos-am6 = "virtual/egl"

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
