SRC_URI = "git://github.com/strukturag/libheif.git;branch=master"
SRCREV = "d2b412553346c8cb057a9fe8a966a2471e732474"

inherit cmake
S = "${WORKDIR}/git"

do_install:append () {
rm -rf ${D}/usr/share/thumbnailers
rm -rf ${D}/usr/share/mime
rm -rf ${D}/usr/share/thumbnailers/heif.thumbnailer
rm -rf ${D}/usr/share/mime/packages
rm -rf ${D}/usr/share/mime/packages/heif.xml
rm -rf ${D}/usr/share/mime/packages/avif.xml 
}

LICENSE="closed"
DEPENDS += "x265 libde265 libjpeg-turbo"
