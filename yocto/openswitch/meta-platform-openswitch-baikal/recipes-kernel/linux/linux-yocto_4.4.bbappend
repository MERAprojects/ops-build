#PR_append = "_baikal"

KBRANCH_baikal  = "standard/mti-malta32"
KMACHINE_baikal ?= "qemumips"

SRCREV_machine_baikal ?= "6bc6d2e669f2fb98d47fe893139593f0de91603b"
COMPATIBLE_MACHINE_baikal = "baikal"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
    file://baikal_new.patch \
    file://defconfig \
"
