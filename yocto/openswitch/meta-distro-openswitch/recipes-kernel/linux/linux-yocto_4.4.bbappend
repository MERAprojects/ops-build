# Copyright (C) 2016 Hewlett Packard Enterprise Development LP

FILESEXTRAPATHS_prepend := "${THISDIR}/files:${THISDIR}/${PN}-4.4:"
LINUX_VERSION = "4.4.24"
SRC_URI += " \
    file://ops-kernel-req.cfg \
    file://support-broadcom-phy-with-igb.patch \
"

RM_WORK_EXCLUDE += "linux-yocto"
