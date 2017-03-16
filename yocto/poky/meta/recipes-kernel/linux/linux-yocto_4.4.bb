KBRANCH ?= "standard/base"

require recipes-kernel/linux/linux-yocto.inc

# board specific branches
KBRANCH_qemuarm  ?= "standard/arm-versatile-926ejs"
KBRANCH_qemuarm64 ?= "standard/qemuarm64"
KBRANCH_qemumips ?= "standard/mti-malta32"
KBRANCH_qemuppc  ?= "standard/qemuppc"
KBRANCH_qemux86  ?= "standard/base"
KBRANCH_qemux86-64 ?= "standard/base"
KBRANCH_qemumips64 ?= "standard/mti-malta64"

SRCREV_machine_qemuarm ?= "c7367f2263b0a08266196e611ccdc8c74a4ae3cc"
SRCREV_machine_qemuarm64 ?= "791d4f7dc60bafb3ed752381316e4391aa91293a"
SRCREV_machine_qemumips ?= "6bc6d2e669f2fb98d47fe893139593f0de91603b"
SRCREV_machine_qemuppc ?= "791d4f7dc60bafb3ed752381316e4391aa91293a"
SRCREV_machine_qemux86 ?= "791d4f7dc60bafb3ed752381316e4391aa91293a"
SRCREV_machine_qemux86-64 ?= "791d4f7dc60bafb3ed752381316e4391aa91293a"
SRCREV_machine_qemumips64 ?= "ceb7dd4fdcd3b7627883fa88b235a0c2ac493808"
SRCREV_machine ?= "791d4f7dc60bafb3ed752381316e4391aa91293a"
SRCREV_meta ?= "170ed03a9d908e2abc8025cf9a62789ab15b3ece"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.4.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.4;destsuffix=${KMETA}"

LINUX_VERSION ?= "4.4.24"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

COMPATIBLE_MACHINE = "qemuarm|qemuarm64|qemux86|qemuppc|qemumips|qemumips64|qemux86-64"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES_append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES_append_qemuall=" cfg/virtio.scc"
KERNEL_FEATURES_append_qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append_qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "" ,d)}"
