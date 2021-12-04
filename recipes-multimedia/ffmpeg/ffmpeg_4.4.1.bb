include ffmpeg.inc 
#
#SRC_URI = "git://github.com/ffmpeg/ffmpeg.git;protocol=https;branch=master"
#SRCREV = "${AUTOREV}"
SRC_URI = "http://ffmpeg.org/releases/${BP}.tar.xz"
SRC_URI[sha256sum] = "eadbad9e9ab30b25f5520fbfde99fae4a92a1ae3c0257a8d68569a4651e30e02"

PACKAGECONFIG[dav1d] = "--enable-libdav1d,--disable-libdav1d,dav1d"

PACKAGECONFIG:append:ugoos-am6 = "gpl vidstab x265 x264 openssl ${KODIFFMPEGADDITIONALS}"
