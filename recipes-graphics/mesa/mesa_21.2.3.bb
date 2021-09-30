require mesa.inc
#SRC_URI_ugoos-am6 = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https;branch=main"
#SRCREV_ugoos-am6 = "${AUTOREV}"

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "7245284a159d2484770e1835a673e79e4322a9ddf43b17859668244946db7174"
DRIDRIVERS_append_ugoos-am6 = "auto"
PACKAGECONFIG_append_ugoos-am6 = " gallium gbm dri opengl gles egl "
PACKAGECONFIG_remove_ugoos-am6 = "vulkan va elf-tls"
