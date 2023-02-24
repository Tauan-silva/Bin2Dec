package com.tauan.bin2dec.domain.model.keyboard

import androidx.annotation.DrawableRes
import com.tauan.bin2dec.domain.interfaces.KeyboardButton

class IconKeyboardButton(
    @DrawableRes val icon: Int,
    override val contentDescription: String,
    override val onClick: () -> Unit,
) : KeyboardButton {
    override val text: String = ""
}