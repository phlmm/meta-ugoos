#
# Linux Support for 64bit Amlogic Meson SoCs
#
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "${AUTOREV}"
#SRCREV = "d58071a8a76d779eedab38033ae4c821c30295a5"
BRANCH = "linux-5.15.y"
URI_STABLE="git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git"
URI_MASTER="git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git"
URI="${URI_STABLE}"
PROTOCOL="git"

#LINUX_VERSION = "5.15.6"
	
# Linux stable tree
SRC_URI:ugoos-am6 = "git://${URI};protocol=${PROTOCOL};branch=${BRANCH} \
			file://defconfig \
"

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION:append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

LINUX_VERSION_EXTENSION:append = "-meson"

PV = "+git${SRCPV}"

#require linux.inc
#

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM ?= "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

INC_PR = "r0"

inherit kernel pkgconfig siteinfo

DEPENDS += "libyaml-native"
DEPENDS += "pkgconfig-native" 
DEPENDS += "openssl-native util-linux-native"
DEPENDS += "gmp-native libmpc-native"
DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"
DEPENDS += "gmp-native libmpc-native"
DEPENDS += "rsync-native"

# yaml and dtschema are required for 5.16+ device tree validation, libyaml is checked
# # via pkgconfig, so must always be present, but we can wrap the others to make them
# # conditional
PACKAGECONFIG ??= ""
PACKAGECONFIG[dt-validation] = ",,python3-dtschema-native"
# we need the wrappers if validation isn't in the packageconfig
DEPENDS += "${@bb.utils.contains('PACKAGECONFIG', 'dt-validation', '', 'python3-dtschema-wrapper-native', d)}"

######
PATCHTOOL = "git"
PATCH_COMMIT_FUNCTIONS = "1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
#kernel_do_compile:prepend() {
#	# setup native pkg-config variables (kconfig scripts call pkg-config directly, cannot generically be overriden to pkg-config-native)
#export PKG_CONFIG_DIR="${STAGING_DIR_NATIVE}${libdir_native}/pkgconfig"
#export PKG_CONFIG_PATH="$PKG_CONFIG_DIR:${STAGING_DATADIR_NATIVE}/pkgconfig"
#export PKG_CONFIG_LIBDIR="$PKG_CONFIG_DIR"
#export PKG_CONFIG_SYSROOT_DIR="" 
#	d.setVar("PKG_CONFIG_DIR", "${STAGING_DIR_NATIVE}${libdir_native}/pkgconfig")
#	d.setVar("PKG_CONFIG_PATH", "${PKG_CONFIG_DIR}:${STAGING_DATADIR_NATIVE}/pkgconfig")
#	d.setVar("PKG_CONFIG_LIBDIR", "${PKG_CONFIG_DIR}")
#	d.setVarFlag("PKG_CONFIG_SYSROOT_DIR", "unexport", "1")
#	d.appendVar("OE_TERMINAL_EXPORTS", " PKG_CONFIG_DIR PKG_CONFIG_PATH PKG_CONFIG_LIBDIR PKG_CONFIG_SYSROOT_DIR")
#}
do_devshell:prepend() {
    d.setVar("PKG_CONFIG_DIR", "${STAGING_DIR_NATIVE}${libdir_native}/pkgconfig")
    d.setVar("PKG_CONFIG_PATH", "${PKG_CONFIG_DIR}:${STAGING_DATADIR_NATIVE}/pkgconfig")
    d.setVar("PKG_CONFIG_LIBDIR", "${PKG_CONFIG_DIR}")
    d.setVarFlag("PKG_CONFIG_SYSROOT_DIR", "unexport", "1")
    d.appendVar("OE_TERMINAL_EXPORTS", " PKG_CONFIG_DIR PKG_CONFIG_PATH PKG_CONFIG_LIBDIR PKG_CONFIG_SYSROOT_DIR")
}
