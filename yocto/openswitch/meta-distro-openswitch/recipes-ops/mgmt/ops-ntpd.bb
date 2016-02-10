SUMMARY = "OpenSwitch Network Time Protocol Daemon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RDEPENDS_${PN} = "ntp"
SRC_URI = "git://git.openswitch.net/openswitch/ops-ntpd;protocol=http \
           file://ops-ntpd.service \
"

SRCREV = "5eb7ba8d05085cc1f70381a3a8d399f2805497df"

# When using AUTOREV, we need to force the package version to the revision of git
# in order to avoid stale shared states.
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

do_install_prepend() {
     install -d ${D}${systemd_unitdir}/system
     install -m 0644 ${WORKDIR}/ops-ntpd.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "ops-ntpd.service"

inherit openswitch setuptools systemd
