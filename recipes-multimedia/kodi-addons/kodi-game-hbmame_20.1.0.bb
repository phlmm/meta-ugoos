SUMMARY = "Kodi game libretro addon"
HOMEPAGE = "https://github.com/kodi-game/game.libretro.hbmame"
BUGTRACKER = "https://github.com/kodi-game/game.libretro.hbmame/issues"
LICENSE = "GPL-2.0"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc

SRC_URI = "git://github.com/kodi-game/game.libretro.hbmame.git;protocol=https;branch=Nexus"
SRCREV = "3da1363b553611f50cf7771775b3e38194161333"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro.hbmame"
