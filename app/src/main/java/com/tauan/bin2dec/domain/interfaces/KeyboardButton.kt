package com.tauan.bin2dec.domain.interfaces

interface KeyboardButton {
    val text: String
    val contentDescription: String
    val onClick: () -> Unit
}