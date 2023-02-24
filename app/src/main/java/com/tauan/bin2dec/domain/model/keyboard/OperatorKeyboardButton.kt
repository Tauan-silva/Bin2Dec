package com.tauan.bin2dec.domain.model.keyboard

import com.tauan.bin2dec.domain.interfaces.KeyboardButton

class OperatorKeyboardButton(
    override val text: String,
    override val contentDescription: String,
    override val onClick: () -> Unit
) : KeyboardButton