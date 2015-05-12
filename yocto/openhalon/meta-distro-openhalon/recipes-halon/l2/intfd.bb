SUMMARY = "Halon Interface Daemon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;beginline=0;endline=14;md5=9bf02f5d4de26e44a8954673dead2ee0"

DEPENDS = "halonutils config-yaml halon-ovsdb"

SRC_URI = "git://git.openhalon.io/openhalon/intfd;protocol=http;preserve_origin=1\
           file://intfd.service"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

do_install_append() {
     install -d ${D}${systemd_unitdir}/system
     install -m 0644 ${WORKDIR}/intfd.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "intfd.service"

inherit halon cmake systemd
