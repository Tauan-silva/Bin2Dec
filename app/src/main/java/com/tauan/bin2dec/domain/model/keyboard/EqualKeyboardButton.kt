package com.tauan.bin2dec.domain.model.keyboard

import com.tauan.bin2dec.domain.interfaces.KeyboardButton

class EqualKeyboardButton(
    override val onClick: () -> Unit,
) : KeyboardButton {

    override val text: String = "="
    override val contentDescription: String = "Equal button"
}