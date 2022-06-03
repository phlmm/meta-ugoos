require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://archive.mesa3d.org/mesa-${PV}.tar.xz"
SRC_URI[sha256sum] = "46940865ffe794db73ac2bc7ab7ff2570042a0b61a8ac43ca1688863e2bc0ef1"
LIC_FILES_CHKSUM:ugoos-am6 := "file://docs/license.rst;md5=9a383ee9f65a4e939d6630e9b067ff58"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = ""
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium vulkan gbm dri opengl gles egl lmsensors "
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl  va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
