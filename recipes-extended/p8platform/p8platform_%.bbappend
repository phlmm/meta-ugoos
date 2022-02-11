FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
ALLOW_EMPTY_${PN} = "1"
FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.a"

