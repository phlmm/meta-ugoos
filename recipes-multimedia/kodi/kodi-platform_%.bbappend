FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SOLIBS = ""
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"