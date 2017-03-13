inherit kernel
require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KERNEL_RELEASE = "4.4.24"
LINUX_VERSION ?= "${KERNEL_RELEASE}"

S = "${WORKDIR}/linux-4.4.24"

PR = "r1"
PV = "${KERNEL_RELEASE}"

SRC_URI = "ftp://192.168.220.47/archive.openswitch.net/linux-4.4.24.tar.xz;name=kernel \
"
#SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-4.4.24.tar.xz;name=kernel \
#"

SRC_URI[kernel.md5sum] = "74f1dcafacf29900fecc9c61318269f8"
SRC_URI[kernel.sha256sum] = "3330eb95e1e34a47fcab513a6825656c9f7c6556d72bcdd38d80662ec8091a7a"

do_install_append() {
   #remove empty directories to avoid errors during packaging
   find ${D}/lib/modules -empty | xargs rm -rf
}

addtask kernel_link_vmlinux after do_compile before do_install