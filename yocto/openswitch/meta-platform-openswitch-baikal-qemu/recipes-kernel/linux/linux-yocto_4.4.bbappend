PR_append = "_baikal_qemu"

KBRANCH  = "standard/mti-malta32"
KMACHINE ?= "qemumips"

SRCREV_machine_qemumips ?= "6bc6d2e669f2fb98d47fe893139593f0de91603b"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
    file://baikal_new.patch \
    file://defconfig \
"
