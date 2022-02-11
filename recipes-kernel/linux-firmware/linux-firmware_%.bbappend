FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRCREV_brcmfmac-sdio-firmware = "0b235bd9ab8cd75938a48fe12608c8fa3ca214fc"

do_install:append() {
        for f in ${WORKDIR}/brcmfmac_sdio-firmware/*.txt ${WORKDIR}/brcmfmac_sdio-firmware/*.bin ${WORKDIR}/brcmfmac_sdio-firmware/*.hcd; do
                install -m 0644 $f ${D}${nonarch_base_libdir}/firmware/brcm
        done
        install -m 0644 ${WORKDIR}/brcmfmac4354-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm
}

