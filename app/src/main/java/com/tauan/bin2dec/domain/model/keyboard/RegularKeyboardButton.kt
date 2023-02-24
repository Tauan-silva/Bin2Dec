package com.tauan.bin2dec.domain.model.keyboard

import com.tauan.bin2dec.domain.interfaces.KeyboardButton

class RegularKeyboardButton(
    override val text: String,
    val onKeyPressed: (String) -> Unit,
    override val contentDescription: String,
) : KeyboardButton {
    override val onClick: () -> Unit = {}
}