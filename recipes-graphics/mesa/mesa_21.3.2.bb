require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "e2e7bafb8307e7abc3bf982f39382fae3619c84b45504920a21504be52f126bd"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = "auto"
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium gbm dri opengl gles egl lmsensors "
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl vulkan va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
