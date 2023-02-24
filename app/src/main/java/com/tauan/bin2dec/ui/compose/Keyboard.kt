package com.tauan.bin2dec.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tauan.bin2dec.R
import com.tauan.bin2dec.domain.interfaces.KeyboardButton
import com.tauan.bin2dec.domain.model.keyboard.*
import com.tauan.bin2dec.ui.ScreenState
import com.tauan.bin2dec.ui.theme.Bin2DecTheme

@Composable
fun Keyboard(
    screenState: ScreenState,
    buttons: List<List<KeyboardButton>>,
    modifier: Modifier = Modifier,
    specificSize: Float = 0f
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
    ) {
        val colors = colors(screenState)
        buttons.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                row.forEach { button ->
                    when (button) {
                        is IconKeyboardButton -> {
                            val painter = painterResource(id = button.icon)
                            KeyboardButton(
                                iconPainter = painter,
                                iconTint = colors[4] as Color,
                                contentDescription = button.contentDescription,
                                onClick = button.onClick,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(colors[0] as Brush)
                            )
                        }
                        is ClearKeyboardButton -> {
                            KeyboardButton(
                                text = button.text,
                                textColor = colors[4] as Color,
                                onClick = button.onClick,
                                contentDescription = button.contentDescription,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(colors[1] as Color)
                            )
                        }
                        is EqualKeyboardButton -> {
                            if (specificSize > 0f) {
                                KeyboardButton(
                                    text = button.text,
                                    textColor = colors[4] as Color,
                                    onClick = button.onClick,
                                    contentDescription = button.contentDescription,
                                    modifier = Modifier
                                        .fillMaxWidth(specificSize)
                                        .height(48.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(colors[2] as Brush)
                                )
                            } else {
                                KeyboardButton(
                                    text = button.text,
                                    textColor = colors[4] as Color,
                                    onClick = button.onClick,
                                    contentDescription = button.contentDescription,
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(colors[2] as Brush)
                                )
                            }

                        }
                        is OperatorKeyboardButton -> {
                            KeyboardButton(
                                text = button.text,
                                textColor = colors[3] as Color,
                                iconTint = colors[3] as Color,
                                onClick = button.onClick,
                                contentDescription = button.contentDescription,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            )

                        }
                        is RegularKeyboardButton -> {
                            KeyboardButton(
                                text = button.text,
                                textColor = colors[4] as Color,
                                onClick = { button.onKeyPressed },
                                contentDescription = button.contentDescription,

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

@Preview(showBackground = true)
@Composable
fun PreviewKeyboard() {
    Bin2DecTheme {

        val keyboard = arrayListOf(arrayListOf(
            RegularKeyboardButton("0", { TODO() }, ""),
            RegularKeyboardButton("1", { TODO() }, ""),
            OperatorKeyboardButton("÷", "") {},
        ), arrayListOf(
            RegularKeyboardButton("00", { TODO() }, ""),
            RegularKeyboardButton("01", { TODO() }, ""),
            OperatorKeyboardButton("x", "") {},
        ), arrayListOf(
            RegularKeyboardButton("10", { TODO() }, ""),
            RegularKeyboardButton("11", { TODO() }, ""),
            OperatorKeyboardButton("-", "") {},
        ), arrayListOf(
            ClearKeyboardButton { TODO() },
            IconKeyboardButton(R.drawable.baseline_backspace_24, "") {},
            OperatorKeyboardButton("÷", "") {},
        ), arrayListOf(EqualKeyboardButton {})
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Keyboard(
                screenState = ScreenState.NIGHT,
                buttons = keyboard,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                specificSize = 0.8f,
            )
        }
    }
}

@Composable
private fun KeyboardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconPainter: Painter? = null,
    iconTint: Color? = null,
    text: String = "",
    textColor: Color? = null,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    contentDescription: String = "",
    modifierText: Modifier = Modifier
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        if (iconPainter != null) {
            Icon(
                painter = iconPainter,
                contentDescription = contentDescription,
                tint = iconTint ?: LocalContentColor.current,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        } else {
            Text(
                text = text,
                color = textColor ?: LocalContentColor.current,
                fontSize = fontSize,
                fontWeight = fontWeight,
                modifier = modifierText.align(Alignment.Center)
            )
        }
    }
}
private fun colors(screenState: ScreenState) = when (screenState) {
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

        val textColor = Color(0xFF060306)

        val operationsButton = Color(0xFF025BA7)

        listOf(
            colorsBtn1, colorBtn2, colorsBtn3, operationsButton, textColor
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
        val operationsButton = Color(0xFF944178)
        val textColor = Color.White
        listOf(
            colorsBtn1, colorBtn2, colorsBtn3, operationsButton, textColor
        )
    }
}
