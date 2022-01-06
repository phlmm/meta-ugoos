SUMMARY = "Kodi visualization addon milkdrop"
HOMEPAGE = "https://github.com/xbmc/visualization.milkdrop"
BUGTRACKER = "https://github.com/xbmc/visualization.milkdrop/issues"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc

SRC_URI = "git://github.com/xbmc/visualization.milkdrop.git;protocol=https;nobranch=1"
SRCREV = "${PV}-${KODICODENAME}"
S = "${WORKDIR}/git"

KODIADDONNAME = "visualization.milkdrop"
