SUMMARY = "Kodi game libretro addon"
HOMEPAGE = "https://github.com/kodi-game/game.libretro.mame"
BUGTRACKER = "https://github.com/kodi-game/game.libretro.mame/issues"
LICENSE = "CLOSED"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc

SRC_URI = "git://github.com/kodi-game/game.libretro.mame.git;protocol=https;branch=master"
SRCREV = "006b3592a9069b2585510f77be615116ea219233"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro.mame"
