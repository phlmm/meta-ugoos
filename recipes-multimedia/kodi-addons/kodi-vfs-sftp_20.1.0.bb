SUMMARY = "Kodi vfs addon"
HOMEPAGE = "https://github.com/xbmc/vfs.sftp"
BUGTRACKER = "https://github.com/xbmc/vfs.sftp/issues"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

inherit kodi-addon
require recipes-multimedia/kodi/kodi-vers.inc
DEPENDS += "openssh libssh"

SRC_URI = "git://github.com/xbmc/vfs.sftp.git;protocol=https;nobranch=1"
SRCREV = "${PV}-${KODICODENAME}"
S = "${WORKDIR}/git"

KODIADDONNAME = "vfs.sftp"
