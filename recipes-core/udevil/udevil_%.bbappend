SYSTEMD_SERVICE:${PN} = "devmon@root.service"
SYSTEMD_SERVICE:${PN} += "devmon@.service"

SYSTEMD_AUTO_ENABLE:ugoos-am6 = "enable"
