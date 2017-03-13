PR_append = "_baikal_qemu"


FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
    file://baikal.patch \
    file://defconfig \
"
