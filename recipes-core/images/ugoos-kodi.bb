DESCRIPTION = "A SD Image UGOOS AM6"
inherit setuptools3
IMAGE_FEATURES += "ssh-server-openssh hwcodecs"

PREFERRED_PROVIDER_virtual/egl = "mesa"
PREFERRED_PROVIDER_virtual/libgl = "mesa"
PREFERRED_PROVIDER_virtual/libgbm = "mesa"
PREFERRED_PROVIDER_virtual/libgles1 = "mesa"
PREFERRED_PROVIDER_virtual/libgles2 = "mesa"
PREFERRED_PROVIDER_virtual/libgles3 = "mesa"
PREFERRED_PROVIDER_virtual/mesa = "mesa"

INIT_MANAGER = "systemd"

EXTRA_IMAGE_FEATURES = "debug-tweaks"
DISTRO_FEATURES += "systemd "
POKY_DEFAULT_DISTRO_FEATURES:remove:ugoos-am6 = "wayland vulkan multiarch  ptest"
MACHINE_FEATURES_BACKFILL:remove:ugoos-am6="qemu-usermode"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    openssh \
    pulseaudio \
    kernel-modules \
    cpufrequtils \
    libyaml \
    linux-firmware \
    mesa \ 
    vim \ 
    gnutls \
    ffmpeg \
    harfbuzz \
    bash-completion \
    kodi \
    kodi-addon-inputstream-adaptive \
    kodi-addon-inputstream-ffmpegdirect \
    kodi-addon-peripheral-joystick \
    kodi-addon-pvr-plutotv \
    kodi-visualization-shadertoy \
    kodi-visualization-waveform \
    kodi-vfs-libarchive \
    kodi-vfs-rar \
    kodi-vfs-sftp \
    kodi-game-libretro \
    kodi-systemd-service \
    i2c-tools \
    alsa-state \
    alsa-utils \
    g12-sound \
    coreutils \ 
    usbutils \
    tzdata \
    transmission \
    transmission-web \
    udevil \ 
    python3-setuptools \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    rsync \
    glibc-utils \
    localedef \
    "
GLIBC_GENERATE_LOCALES:append = " bg_BG.UTF-8"
# 4G Rootfs
IMAGE_ROOTFS_SIZE = "4194304"

inherit core-image
IMAGE_CLASSES += "extrausers"

EXTRA_USERS_PARAMS = " \
	useradd -p 'ugoos' ugoos; \
	usermod -P 'root' root; \
"
WIC_COMMAND:ugoos-am6 = ""
