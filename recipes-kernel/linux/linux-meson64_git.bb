#
# Linux Support for 64bit Amlogic Meson SoCs
#

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

INC_PR = "r0"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "${AUTOREV}"
BRANCH = "linux-5.16.y"
URI_STABLE="git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git"
URI_MASTER="git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git"
URI="${URI_STABLE}"
PROTOCOL="git"

KERNEL_VERSION_SANITY_SKIP="1"
KERNEL_CLASSES = "kernel-uimage-meson"
LINUX_VERSION_EXTENSION:append = "-meson64"
KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"
LINUX_VERSION_EXTENSION:append = "-meson"

PV = "+git${SRCPV}"
inherit kernel pkgconfig siteinfo

S = "${WORKDIR}/git"

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
#PATCHTOOL = "git"
#PATCH_COMMIT_FUNCTIONS = "1"

SRC_URI:ugoos-am6 = "git://${URI};protocol=${PROTOCOL};branch=${BRANCH} \
           file://0001-HACK-set-meson-gx-cma-pool-to-896MB.patch \
           file://0002-HACK-set-meson-g12-cma-pool-to-896MB.patch \
           file://0003-HACK-arm64-fix-Kodi-sysinfo-CPU-information.patch \
           file://0004-HACK-arm64-dts-meson-add-LibreELEC-device-tree-overl.patch \
           file://0005-HACK-arm64-dts-meson-gx-add-ATF-BL32-reserved-memory.patch \
           file://0006-HACK-arm64-meson-add-Amlogic-Meson-GX-PM-Suspend.patch \
           file://0007-HACK-arm64-dts-meson-add-support-for-GX-PM-and-Virtu.patch \
           file://0008-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Khadas-.patch \
           file://0009-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Khadas-.patch \
           file://0010-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Minix-N.patch \
           file://0011-HACK-arm64-dts-meson-remove-opps-below-1GHz-for-g12-.patch \
           file://0012-HACK-usb-hub-disable-autosuspend-for-Genesys-Logic-H.patch \
           file://0013-FROMGIT-arm64-dts-meson-sm1-odroid-add-cec-nodes.patch \
           file://0014-FROMGIT-arm64-dts-amlogic-meson-g12-Fix-thermal-zone.patch \
           file://0015-FROMGIT-arm64-dts-meson-gxbb-wetek-use-updated-LED-b.patch \
           file://0016-FROMGIT-arm64-dts-meson-p241-add-vcc_5v-regulator.patch \
           file://0017-FROMGIT-arm64-dts-meson-p241-add-sound-support.patch \
           file://0018-FROMLIST-v1-ASoC-meson-aiu-Fix-HDMI-codec-control-se.patch \
           file://0019-FROMLIST-v1-arm64-dts-meson-make-dts-use-gpio-fan-ma.patch \
           file://0020-FROMLIST-v1-pwm-meson-Drop-always-false-check-from-..patch \
           file://0021-FROMLIST-v1-pwm-meson-Drop-useless-check-for-channel.patch \
           file://0022-FROMLIST-v1-pwm-meson-Simplify-duplicated-per-channe.patch \
           file://0023-FROMLIST-v1-pwm-meson-Drop-always-false-check-from-..patch \
           file://0024-FROMLIST-v1-drm-connector-Add-define-for-HDMI-1.4-Ma.patch \
           file://0025-FROMLIST-v1-watchdog-meson_gxbb_wdt-remove-watchdog_.patch \
           file://0026-FROMLIST-v2-arm64-dts-meson-add-initial-device-tree-.patch \
           file://0027-FROMLIST-v2-dt-bindings-arm-amlogic-add-H96-Max-bind.patch \
           file://0028-FROMLIST-v2-dt-bindings-vendor-prefixes-add-haochuan.patch \
           file://0029-FROMLIST-v2-arm64-dts-meson-add-initial-device-trees.patch \
           file://0030-FROMLIST-v2-dt-bindings-arm-amlogic-add-A95XF3-AIR-b.patch \
           file://0031-FROMLIST-v2-dt-bindings-vendor-prefixes-add-cyx-pref.patch \
           file://0032-FROMLIST-v2-arm64-dts-meson-add-initial-device-trees.patch \
           file://0033-FROMLIST-v2-dt-bindings-arm-amlogic-add-X96-AIR-bind.patch \
           file://0034-FROMLIST-v2-arm64-dts-meson-add-common-SM1-ac2xx-dts.patch \
           file://0035-FROMLIST-v4-phy-amlogic-phy-meson-gxl-usb2-fix-share.patch \
           file://0036-FROMLIST-v4-phy-amlogic-meson8b-usb2-Use-dev_err_pro.patch \
           file://0037-FROMLIST-v4-phy-amlogic-meson8b-usb2-fix-shared-rese.patch \
           file://0038-FROMLIST-v2-media-v4l2-mem2mem-Apply-DST_QUEUE_OFF_B.patch \
           file://0039-FROMLIST-v1-arm64-dts-meson-sm1-add-spdifin-spdifout.patch \
           file://0040-FROMLIST-v1-pinctrl-meson-g12a-add-more-pwm_f-option.patch \
           file://0041-FROMLIST-v1-arm64-dts-meson-g12-common-add-more-pwm_.patch \
           file://0042-FROMLIST-v1-arm64-dts-meson-g12-common-add-uart_ao_b.patch \
           file://0043-FROMLIST-v1-mmc-meson-gx-fix-deferred-probing.patch \
           file://0044-WIP-mmc-meson-gx-mmc-set-core-clock-phase-to-270-deg.patch \
           file://0045-WIP-drivers-meson-vdec-remove-redundant-if-statement.patch \
           file://0046-WIP-drivers-meson-vdec-improve-mmu-and-fbc-handling-.patch \
           file://0047-WIP-drivers-meson-vdec-add-HEVC-decode-codec.patch \
           file://0048-WIP-drivers-meson-vdec-add-handling-to-HEVC-decoder-.patch \
           file://0049-WIP-drivers-meson-vdec-add-HEVC-support-to-GXBB.patch \
           file://0050-WIP-drivers-meson-vdec-add-VP9-support-to-GXM.patch \
           file://0051-WIP-drivers-meson-vdec-check-if-parser-has-really-pa.patch \
           file://0052-WIP-arm64-dts-meson-radxa-zero-add-support-for-the-u.patch \
           file://0053-WIP-arm64-dts-meson-add-audio-playback-to-p201.patch \
           file://0054-WIP-arm64-dts-meson-add-audio-playback-to-p200.patch \
           file://0055-WIP-arm64-dts-meson-add-audio-playback-to-p212-s905x.patch \
           file://0056-WIP-arm64-dts-meson-add-audio-playback-to-u200.patch \
           file://0057-WIP-arm64-dts-meson-add-Headphone-output-to-Beelink-.patch \
           file://0058-WIP-ASoC-hdmi-codec-reorder-channel-allocation-list.patch \
           file://0059-WIP-ALSA-pcm-fix-ELD-constraints-for-some-compressed.patch \
           file://0060-WIP-ALSA-pcm-ignore-formats-not-supported-by-kodi-in.patch \
           file://0061-WIP-dt-bindings-arm-amlogic-add-support-for-the-Tani.patch \
           file://0062-WIP-arm64-dts-meson-add-support-for-the-Tanix-TX5-Ma.patch \
           file://0063-WIP-arm64-dts-meson-add-multiple-MeCool-device-trees.patch \
           file://0064-WIP-dt-bindings-arm-amlogic-add-support-for-Minix-NE.patch \
           file://0065-WIP-arm64-dts-meson-add-initial-device-tree-for-Mini.patch \
           file://0066-WIP-media-rc-add-keymap-for-Beelink-Mini-MXIII-remot.patch \
           file://0067-WIP-dt-bindings-arm-amlogic-add-support-for-Beelink-.patch \
           file://0068-WIP-arm64-dts-meson-add-support-for-Beelink-Mini-MXI.patch \
           file://0069-WIP-arm64-dts-meson-add-Broadcom-WiFi-to-P212-dtsi.patch \
           file://0070-WIP-arm64-dts-meson-remove-Broadcom-WiFi-BT-nodes-fr.patch \
           file://defconfig \
           "

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
