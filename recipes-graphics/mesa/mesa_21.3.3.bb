require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "ad7f4613ea7c5d08d9fcb5025270199e6ceb9aa99fd72ee572b70342240a8121"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = "auto"
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium gbm dri opengl gles egl lmsensors "
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl vulkan va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
