require recipes-multimedia/kodi/kodi_git.bb
DEPENDS += "kodi kodi-platform"
DEPENDS += "mesa glm jsoncpp"
DEPENDS += "openssh libssh"
DEPENDS += "libtinyxml"
DEPENDS += "libtinyxml2"
DEPENDS += "systemd"
DEPENDS += "libsdl libarchive bzip2 lzo lz4 zlib xz nlohmann-json openssl ffmpeg nettle libpng gnutls lcms libjpeg-turbo libraw libde265  pugixml wavpack libopenmpt x265 dav1d"

SRC_URI:remove = " \
        file://0001-FindCrossGUID.cmake-fix-for-crossguid-0.2.2.patch \
        file://kodi-995.01-fix-missing-wayland-scanner-pkg-config.patch \
"

inherit pkgconfig kodi-addon


EXTRA_OEMAKE:append = " -C ${S}/tools/depends/target/binary-addons PREFIX=${D}/usr "

do_compile[network] = "1"
