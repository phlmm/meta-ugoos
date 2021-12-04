require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "2b0dc2540cb192525741d00f706dbc4586349185dafc65729c7fda0800cc474d"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = "auto"
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium gbm dri opengl gles egl lmsensors "
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl vulkan va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
