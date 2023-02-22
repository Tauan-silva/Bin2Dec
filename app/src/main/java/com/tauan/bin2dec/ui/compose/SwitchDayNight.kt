package com.tauan.bin2dec.ui.compose

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchDayNight(onCheckedChange: () -> Unit) {
    var isDarkTheme by remember {
        mutableStateOf(false)
    }

    Switch(
        checked = isDarkTheme,
        colors = SwitchDefaults.colors(
            uncheckedBorderColor = Color(0xFF025BA7),
            uncheckedTrackColor = Color(0xFFA6CEE9),
            uncheckedThumbColor = Color(0xFF036DA0),
            checkedBorderColor = Color(0xFF944178),
            checkedTrackColor = Color.DarkGray,
            checkedThumbColor = Color(0xFF944178),
        ),
        onCheckedChange = {
            isDarkTheme = it
            onCheckedChange()
        }
    )
}