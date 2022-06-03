# Copyright (C) 2022 phlmm <milev.philip@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "common packages for libretor"
HOMEPAGE = "https://github.com/libretro/libretro-common"
LICENSE = "CLOSED"
SECTION = ""
DEPENDS = ""

SRC_URI = "git://github.com/libretro/libretro-common.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
ALLOW_EMPTY_${PN} = "1"

do_install() {
    install -d ${D}/usr
    install -d ${D}/usr/include/
    install -d ${D}/usr/include/libretro-common
    cp -r ${S}/* ${D}/usr/
    cp -r ${S}/include/*.* ${D}/usr/include/libretro-common
    rm -r ${D}/usr/samples*
}
FILES:${PN} += "/usr/*"
