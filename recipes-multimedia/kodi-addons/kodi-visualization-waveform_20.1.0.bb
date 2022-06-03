SUMMARY = "Kodi visualization addon waveform"
HOMEPAGE = "https://github.com/xbmc/visualization.waveform"
BUGTRACKER = "https://github.com/xbmc/visualization.waveform/issues"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc
DEPENDS += "mesa glm"

SRC_URI = "git://github.com/xbmc/visualization.waveform.git;protocol=https;branch=Nexus"
#SRCREV = "${AUTOREV}"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

KODIADDONNAME = "visualization.waveform"
