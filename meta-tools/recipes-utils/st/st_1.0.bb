SUMMARY = "Advantech serial port test tool"
SECTION = "base"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://github.com/ADVANTECH-Corp/RISC_tools_source/raw/master/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "16674247c9543d34d5991e3e8fcdcdc3"
SRC_URI[sha256sum] = "8436635ba0991310d9555acbd8ad2bfeca2dde12cbe6faf1c4c9869a8260f758"


S = "${WORKDIR}/st"

inherit autotools pkgconfig

EXTRA_OECONF = "--host arm-poky-linux-gnueabi --prefix=/usr/"

# We overwrite do_configure() to avoid perform autoreconf again
do_configure() {
    oe_runconf
}

