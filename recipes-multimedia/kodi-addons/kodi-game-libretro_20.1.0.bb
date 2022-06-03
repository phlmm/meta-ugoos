SUMMARY = "Kodi game libretro addon"
HOMEPAGE = "https://github.com/kodi-game/game.libretro"
BUGTRACKER = "https://github.com/kodi-game/game.libretro/issues"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc

DEPENDS += "libtinyxml2 libretro-common libretro-rcheevos"

SRC_URI = "git://github.com/kodi-game/game.libretro.git;protocol=https;branch=Nexus"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro"
