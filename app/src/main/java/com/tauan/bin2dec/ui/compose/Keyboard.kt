package com.tauan.bin2dec.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tauan.bin2dec.R
import com.tauan.bin2dec.ui.ScreenState

@Composable
fun Keyboard(
    screenState: ScreenState,
    onKeyPressed: (String) -> Unit,
    onBackPressed: () -> Unit,
    onClearPressed: () -> Unit,
    onEqualPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboard = listOf(
        listOf("0", "1", "icon"),
        listOf("00", "01", "clr"),
        listOf("10", "11", "="),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
    ) {
        val colors = colors(screenState)
        keyboard.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                row.forEach { key ->
                    when (key) {
                        "icon" -> {
                            KeyboardButton(
                                screenState,
                                hasIcon = true,
                                icon = R.drawable.baseline_backspace_24,
                                contentDescription = "Button to delete one character",
                                onClick = onBackPressed,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(colors[0] as Brush)
                            )
                        }
                        "clr" -> {
                            KeyboardButton(
                                screenState,
                                text = key,
                                onClick = onClearPressed,
                                contentDescription = "button $key",
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(colors[1] as Color)
                            )
                        }
                        "=" -> {
                            KeyboardButton(
                                screenState,
                                text = key,
                                onClick = onEqualPressed,
                                contentDescription = "button to make conversion",
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(colors[2] as Brush)
                            )
                        }
                        else -> {
                            KeyboardButton(
                                screenState,
                                text = key,
                                onClick = { onKeyPressed(key) },
                                contentDescription = "button $key",
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

private fun colors(screenState: ScreenState) = when(screenState) {
    ScreenState.DAY -> {
        val colorsBtn1 = Brush.linearGradient(
            colors = listOf(
                Color(0xFF025BA7),
                Color(0xFF036DA0),
                Color(0xFF05A7A7),
            ),
        )

        val colorBtn2 = Color(0xFFA6CEE9)
        val colorsBtn3 = Brush.linearGradient(
            colors = listOf(
                Color(0xFF05A7A7),
                Color(0xF006E0BE),
                Color(0xFF07FFD8),
            ),
        )

        listOf(
            colorsBtn1,
            colorBtn2,
            colorsBtn3
        )
    }
    ScreenState.NIGHT -> {
        val colorsBtn1 = Brush.linearGradient(
            colors = listOf(
                Color(0xFF944178),
                Color(0xFFB95745),
                Color(0xFFDA6A2D),
            ),
        )

        val colorBtn2 = Color.DarkGray
        val colorsBtn3 = Brush.linearGradient(
            colors = listOf(
                Color(0xFFBD5A24),
                Color(0xFFE8721B),
                Color(0xFFF67A09),
            ),
        )

        listOf(
            colorsBtn1,
            colorBtn2,
            colorsBtn3
        )
    }
}

@Composable
private fun KeyboardButton(
    screenState: ScreenState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    hasIcon: Boolean = false,
    icon: Int = 0,
    text: String = "",
    contentDescription: String = "",
    modifierText: Modifier = Modifier
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        when(screenState) {
            ScreenState.DAY -> {
                if (hasIcon) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = contentDescription,
                        tint = Color(0xFF060306),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                    )
                } else {
                    Text(
                        text = text,
                        color = Color(0xFF060306),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifierText.align(Alignment.Center)
                    )
                }
            }
            ScreenState.NIGHT -> {
                if (hasIcon) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = contentDescription,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                    )
                } else {
                    Text(
                        text = text,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifierText.align(Alignment.Center)
                    )
                }
            }
        }
    }
}
