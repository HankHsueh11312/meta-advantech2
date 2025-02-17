SUMMARY = "ADV Add virtual network"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://add_virtual_network.sh \
	   file://add_virtual_network.service"

inherit systemd

do_install() {
    install -d ${D}/tools
    install -m 755 ${WORKDIR}/add_virtual_network.sh ${D}/tools/add_virtual_network.sh

    # systemd
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/add_virtual_network.service ${D}${systemd_unitdir}/system
    fi
}

SYSTEMD_SERVICE:${PN} = "add_virtual_network.service"
SYSTEMD_AUTO_ENABLE = "disable"

FILES:${PN} = "/tools"
