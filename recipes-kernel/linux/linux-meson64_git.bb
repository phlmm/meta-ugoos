#
# Linux Support for 64bit Amlogic Meson SoCs
#

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

INC_PR = "r0"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:ugoos-am6 = "git://${URI};protocol=${PROTOCOL};branch=${BRANCH} \
           file://defconfig \
            file://amlogic-0001-HACK-set-meson-gx-cma-pool-to-896MB.patch \
            file://amlogic-0002-HACK-set-meson-g12-cma-pool-to-896MB.patch \
            file://amlogic-0003-HACK-arm64-fix-Kodi-sysinfo-CPU-information.patch \
            file://amlogic-0005-HACK-arm64-meson-add-Amlogic-Meson-GX-PM-Suspend.patch \
            file://amlogic-0006-HACK-arm64-dts-meson-add-support-for-GX-PM-and-Virtu.patch \
            file://amlogic-0007-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Khadas-.patch \
            file://amlogic-0008-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Khadas-.patch \
            file://amlogic-0009-HACK-arm64-dts-meson-add-rtc-vrtc-aliases-to-Minix-N.patch \
            file://amlogic-0010-HACK-usb-hub-disable-autosuspend-for-Genesys-Logic-H.patch \
            file://amlogic-0011-HACK-of-partial-revert-of-fdt.c-changes.patch \
            file://amlogic-0028-FROMLIST-v1-arm64-dts-meson-make-dts-use-gpio-fan-ma.patch \
            file://amlogic-0038-FROMLIST-v1-mmc-meson-gx-fix-deferred-probing.patch \
            file://amlogic-0039-FROMLIST-v3-Bluetooth-btrtl-Add-support-for-RTL8822C.patch \
            file://amlogic-0040-FROMLIST-v3-Bluetooth-hci_h5-Add-power-reset-via-gpi.patch \
            file://amlogic-0043-FROMLIST-v1-drivers-meson-vdec-add-VP9-support-to-GX.patch \
            file://amlogic-0045-FROMLIST-v2-dt-bindings-vendor-prefixes-Add-Titan-Mi.patch \
            file://amlogic-0046-FROMLIST-v2-dt-bindings-auxdisplay-Add-Titan-Micro-E.patch \
            file://amlogic-0047-FROMLIST-v2-docs-ABI-document-tm1628-attribute-displ.patch \
            file://amlogic-0048-FROMLIST-v2-auxdisplay-add-support-for-Titanmec-TM16.patch \
            file://amlogic-0049-FROMLIST-v2-arm64-dts-meson-gxl-s905w-tx3-mini-add-s.patch \
            file://amlogic-0050-FROMLIST-v1-usb-core-improve-handling-of-hubs-with-n.patch \
            file://amlogic-0053-WIP-ASoC-hdmi-codec-reorder-channel-allocation-list.patch \
            file://amlogic-0054-WIP-mmc-meson-gx-mmc-set-core-clock-phase-to-270-deg.patch \
            file://amlogic-0055-WIP-arm64-dts-meson-add-Broadcom-WiFi-to-P212-dtsi.patch \
            file://amlogic-0056-WIP-arm64-dts-meson-move-pwm_ef-node-in-P212-dtsi.patch \
            file://amlogic-0057-WIP-arm64-dts-meson-remove-WiFi-BT-nodes-from-Khadas.patch \
            file://amlogic-0058-WIP-arm64-dts-meson-set-p212-p23x-q20x-SDIO-to-100MH.patch \
            file://amlogic-0059-WIP-arm64-dts-meson-add-UHS-SDIO-capabilities-to-p21.patch \
            file://amlogic-0060-WIP-arm64-dts-meson-remove-SDIO-node-from-Khadas-VIM.patch \
            file://amlogic-0061-WIP-arm64-dts-meson-add-audio-playback-to-S905X-P212.patch \
            file://amlogic-0062-WIP-drivers-meson-vdec-remove-redundant-if-statement.patch \
            file://amlogic-0063-WIP-drivers-meson-vdec-improve-mmu-and-fbc-handling-.patch \
            file://amlogic-0064-WIP-drivers-meson-vdec-add-HEVC-decode-codec.patch \
            file://amlogic-0065-WIP-drivers-meson-vdec-add-handling-to-HEVC-decoder-.patch \
            file://amlogic-0067-WIP-drivers-meson-vdec-check-if-parser-has-really-pa.patch \
            file://amlogic-0068-WIP-arm64-dts-meson-radxa-zero-add-support-for-the-u.patch \
            file://amlogic-0069-WIP-dt-bindings-arm-amlogic-add-support-for-Radxa-Ze.patch \
            file://amlogic-0070-WIP-arm64-dts-meson-add-support-for-Radxa-Zero2.patch \
            file://amlogic-0071-WIP-arm64-dts-meson-add-audio-playback-to-p201.patch \
            file://amlogic-0072-WIP-arm64-dts-meson-add-audio-playback-to-p200.patch \
            file://amlogic-0073-WIP-arm64-dts-meson-add-audio-playback-to-u200.patch \
            file://amlogic-0074-WIP-arm64-dts-meson-add-Headphone-output-to-Beelink-.patch \
            file://amlogic-0075-WIP-dt-bindings-arm-amlogic-add-support-for-the-Tani.patch \
            file://amlogic-0076-WIP-arm64-dts-meson-add-support-for-the-Tanix-TX5-Ma.patch \
            file://amlogic-0077-WIP-arm64-dts-meson-add-multiple-MeCool-device-trees.patch \
            file://amlogic-0078-WIP-dt-bindings-arm-amlogic-add-support-for-Minix-NE.patch \
            file://amlogic-0079-WIP-arm64-dts-meson-add-initial-device-tree-for-Mini.patch \
            file://amlogic-0081-WIP-dt-bindings-arm-amlogic-add-support-for-Beelink-.patch \
            file://amlogic-0082-WIP-arm64-dts-meson-add-support-for-Beelink-Mini-MXI.patch \
            file://amlogic-0084-WIP-dt-bindings-arm-amlogic-add-support-for-MeCool-M.patch \
            file://amlogic-0085-WIP-arm64-dts-meson-add-support-for-MeCool-M8S-Pro-W.patch \
            file://amlogic-0086-WIP-dt-bindings-arm-amlogic-add-Vero-4K-binding.patch \
            file://amlogic-0087-WIP-arm64-dts-meson-add-support-for-OSMC-Vero-4K.patch \
            file://amlogic-0088-WIP-drm-meson-meson_vclk-fix-VIC-alternate-timings.patch \
            file://amlogic-0089-WIP-auxdisplay-fixup-for-TM1628-display-controller-d.patch \
            file://amlogic-0090-WIP-arm64-dts-meson-g12a-x96-max-add-support-for-the.patch \
"

SRCREV = "${AUTOREV}"
#SRCREV = "f443e374ae131c168a065ea1748feac6b2e76613"
BRANCH = "linux-5.18.y"
TREE="stable"
URI="git.kernel.org/pub/scm/linux/kernel/git/${TREE}/linux.git"
#URI="${URI_MASTER}"
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


do_devshell:prepend() {
    d.setVar("PKG_CONFIG_DIR", "${STAGING_DIR_NATIVE}${libdir_native}/pkgconfig")
    d.setVar("PKG_CONFIG_PATH", "${PKG_CONFIG_DIR}:${STAGING_DATADIR_NATIVE}/pkgconfig")
    d.setVar("PKG_CONFIG_LIBDIR", "${PKG_CONFIG_DIR}")
    d.setVarFlag("PKG_CONFIG_SYSROOT_DIR", "unexport", "1")
    d.appendVar("OE_TERMINAL_EXPORTS", " PKG_CONFIG_DIR PKG_CONFIG_PATH PKG_CONFIG_LIBDIR PKG_CONFIG_SYSROOT_DIR")
}
