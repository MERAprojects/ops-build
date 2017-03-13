require go.inc

DEPENDS = "go-bootstrap-native"

SSTATE_SCAN_CMD = "true"

SRC_URI = "${SRC_URI_PREFIX}/go${PV}.src.tar.gz;name=go_1_8;subdir=go-${PV}"
SRC_URI[go_1_8.md5sum] = "7743960c968760437b6e39093cfe6f67"
SRC_URI[go_1_8.sha256sum] = "406865f587b44be7092f206d73fc1de252600b79b3cacc587b74b5ef5c623596"

LIC_FILES_CHKSUM = "file://${WORKDIR}/go-${PV}/go/LICENSE;md5=5d4950ecb7b26d2c5e4e7b4e0dd74707"

SRC_URI += "file://fix-cross-compilation.patch"
