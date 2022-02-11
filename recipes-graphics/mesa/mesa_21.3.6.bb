require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "96bb761fd546e9aa41d025fcc025225c5668443839dae21e3731959beb096736"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = "auto"
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium vulkan gbm dri opengl gles egl lmsensors "
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl  va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
