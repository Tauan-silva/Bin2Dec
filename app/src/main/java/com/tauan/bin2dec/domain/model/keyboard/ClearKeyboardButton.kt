package com.tauan.bin2dec.domain.model.keyboard

import com.tauan.bin2dec.domain.interfaces.KeyboardButton

class ClearKeyboardButton(
    override val onClick: () -> Unit,
) : KeyboardButton {

    override val text = "C"
    override val contentDescription = "Button to clear all numbers"
}