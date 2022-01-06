DESCRIPTION = "A SD/MMC Image for Amlogic Meson SoCs with embedded kernel on the filesystem"
require ugoos-kodi.bb
IMAGE_FEATURES:append = " dbg-pkgs tools-debug tools-testapps debug-tweaks tools-sdk dev-pkgs"
DEBUG_build = "1"
INHIBIT_PACKAGE_STRIP = "1"
BBDEBUG = "yes"
INHERIT += "buildhistory"
BUILDHISTORY_COMMIT = "1"

PACKAGE_EXCLUDE = "libcec-dev kodi-platform-dev"
PACKAGE_INSTALL:remove = "libcec-dev kodi-platform-dev"
