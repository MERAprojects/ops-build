# Copyright (C) 2015 Hewlett Packard Enterprise Development LP

PR_append = "_baikal_qemu"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PLATFORM_PATH = "Mera/baikal-qemu"
PLATFORM_FLAVOR = "${@bb.utils.contains("IMAGE_FEATURES", "ops-p4", "P4", "",d)}"
