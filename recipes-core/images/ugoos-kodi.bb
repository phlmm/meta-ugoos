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
    ${CORE_IMAGE_EXTRA_INSTALL} \
    alsa-lib \
    alsa-state \
    alsa-utils \
    bash-completion \
    cifs-utils \
    coreutils \
    cpufrequtils \
    ffmpeg \
    g12-sound \
    glibc-utils \
    gnutls \
    harfbuzz \
    i2c-tools \
    kernel-modules \
    kodi \
    kodi-addon-inputstream-adaptive \
    kodi-addon-inputstream-ffmpegdirect \
    kodi-addon-peripheral-joystick \
    kodi-addon-pvr-plutotv \
    kodi-game-libretro \
    kodi-systemd-service \
    kodi-vfs-libarchive \
    kodi-vfs-rar \
    kodi-vfs-sftp \
    kodi-visualization-shadertoy \
    kodi-visualization-waveform \
    libyaml \
    linux-firmware \
    localedef \
    mesa \
    openssh \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    pulseaudio \
    python3-setuptools \
    rsync \
    systemd-serialgetty \
    transmission \
    transmission-web \
    tzdata \
    udevil \
    upower \
    usbutils \
    util-linux \
    vim \
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
