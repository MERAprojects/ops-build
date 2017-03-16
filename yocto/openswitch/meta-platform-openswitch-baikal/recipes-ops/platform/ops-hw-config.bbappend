# Copyright (C) 2015 Hewlett Packard Enterprise Development LP

PR_append = "_baikal"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PLATFORM_PATH = "Mera/baikal"
PLATFORM_FLAVOR = "${@bb.utils.contains("IMAGE_FEATURES", "ops-p4", "P4", "",d)}"
