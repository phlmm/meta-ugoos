require recipes-graphics/mesa/mesa.inc

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz "
SRC_URI[sha256sum] = "f1ec269b7db6568347e554fdbe42e09e1632ac5f6a48913e0fb3def654749d95"

PACKAGECONFIG[elf-tls]= ""
DRIDRIVERS:append:ugoos-am6 = "auto"
PACKAGECONFIG:append:ugoos-am6 = " panfrost gallium gbm dri opengl gles egl lmsensors"
PACKAGECONFIG:remove:ugoos-am6 = "lima virgl vulkan va elf-tls"
PACKAGECONFIG:class-native:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-target:remove:ugoos-am6 = "lima virgl vulkan va elf-tls x11"
PACKAGECONFIG:class-nativesdk:remove:ugoos-am6= "lima virgl vulkan va elf-tls x11"
