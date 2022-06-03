# Copyright (C) 2022 phlmm <milev.philip@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = ""
HOMEPAGE = "https://github.com/RetroAchievements/rcheevos.git"
LICENSE = "MIT"
SECTION = ""
DEPENDS = ""

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
LIC_FILES_CHKSUM = "file://LICENSE;md5=466b936a0a89a7677882b9a92c189c2f"
SRC_URI = "git://github.com/RetroAchievements/rcheevos.git;protocol=https;branch=master \
            file://CMakeLists.txt-rcheevos \
"
SRCREV = "203fc282d542a058241f3c5a28a2d0ca15e628cb"
#SRCREV ="c8ed6ca74f905ea0c256250e46cced579922880001337e7c3d3d68179ad89d4e"
S = "${WORKDIR}/git"


do_patch() {
    cp ${WORKDIR}/CMakeLists.txt-rcheevos ${S}/CMakeLists.txt
}

inherit cmake
