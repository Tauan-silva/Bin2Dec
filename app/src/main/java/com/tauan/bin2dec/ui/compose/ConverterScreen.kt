package com.tauan.bin2dec.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tauan.bin2dec.R
import com.tauan.bin2dec.domain.interfaces.KeyboardButton
import com.tauan.bin2dec.domain.model.keyboard.*
import com.tauan.bin2dec.ui.ConverterViewModel
import com.tauan.bin2dec.ui.ScreenState
import com.tauan.bin2dec.ui.theme.MyColors


@Composable
fun ConverterScreen(viewModel: ConverterViewModel, modifier: Modifier = Modifier) {

    val nightBrush = Brush.linearGradient(MyColors.nightColors)
    val dayBrush = Brush.linearGradient(MyColors.dayColors)

    val currentState = viewModel.screenState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (currentState.value == ScreenState.DAY) dayBrush else nightBrush),
    ) {
        val calculateKeyboard = arrayListOf(
            arrayListOf(
                RegularKeyboardButton("0", { viewModel.onKeyPressed("0") }, ""),
                RegularKeyboardButton("1", { viewModel.onKeyPressed("1") }, ""),
                OperatorKeyboardButton("÷", "") {},
            ),
            arrayListOf(
                RegularKeyboardButton("00", { viewModel.onKeyPressed("00") }, ""),
                RegularKeyboardButton("01", { viewModel.onKeyPressed("01") }, ""),
                OperatorKeyboardButton("x", "") {},
            ),
            arrayListOf(
                RegularKeyboardButton("10", { viewModel.onKeyPressed("10") }, ""),
                RegularKeyboardButton("11", { viewModel.onKeyPressed("11") }, ""),
                OperatorKeyboardButton("-", "") {},
            ),
            arrayListOf(
                ClearKeyboardButton { viewModel.onClearPressed() },
                IconKeyboardButton(
                    R.drawable.baseline_backspace_24,
                    ""
                ) { viewModel.onBackPressed() },
                OperatorKeyboardButton("÷", "") {},
            ),
        )

        val convertKeyboard = arrayListOf(
            arrayListOf(
                RegularKeyboardButton("0", { viewModel.onKeyPressed("0") }, "0 button"),
                RegularKeyboardButton("1", { viewModel.onKeyPressed("1") }, "1 button"),
                IconKeyboardButton(
                    R.drawable.baseline_backspace_24,
                    ""
                ) { viewModel.onBackPressed() },
            ),
            arrayListOf(
                RegularKeyboardButton("00", { viewModel.onKeyPressed("00") }, "00 button"),
                RegularKeyboardButton("01", { viewModel.onKeyPressed("01") }, "01 button"),
                ClearKeyboardButton { viewModel.onClearPressed() },
            ),
            arrayListOf(
                RegularKeyboardButton("10", { viewModel.onKeyPressed("10") }, "10 button"),
                RegularKeyboardButton("11", { viewModel.onKeyPressed("11") }, "11 button"),
                EqualKeyboardButton { viewModel.onEqualPressed() },
            ),
        )

        val visibility = viewModel.keyboardCalculatorVisibility.collectAsState()

        AnimatedVisibility(
            visible = !visibility.value,
        ) {
            Content(viewModel, convertKeyboard, modifier.align(Alignment.Center))
        }

        AnimatedVisibility(
            visible = visibility.value,
        ) {
            Content(viewModel, calculateKeyboard, modifier.align(Alignment.Center))
        }
    }

}

@Composable
private fun Content(
    viewModel: ConverterViewModel,
    keyboard: List<List<KeyboardButton>>,
    modifier: Modifier = Modifier
) {
    val currentState = viewModel.screenState.collectAsState()
    val binaryTextState = viewModel.binaryTextState.collectAsState()
    val resultTextState = viewModel.resultTextState.collectAsState()
    val resultVisibility = viewModel.resultVisibility.collectAsState()

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 16.dp),
        modifier = modifier
    ) {
        val cardColor =
            if (currentState.value == ScreenState.DAY) Color.White else Color(0xFF060306)
        val binaryTextColor =
            if (currentState.value == ScreenState.NIGHT) Color.White else Color(0xFF060306)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(cardColor)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Spacer(modifier = Modifier.size(32.dp))
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
                ) {
                    SwitchDayNight(onCheckedChange = {
                        viewModel.changeTheme()
                    })
                    Spacer(modifier = Modifier.size(16.dp))
                }
                AnimatedVisibility(
                    visible = !resultVisibility.value, exit = slideOutVertically()
                ) {
                    Text(
                        text = binaryTextState.value,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = binaryTextColor,
                        textAlign = TextAlign.Center,
                        lineHeight = TextUnit(45f, type = TextUnitType.Sp),
                        maxLines = 3,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(0.8f)
                    )
                }

                AnimatedVisibility(
                    visible = resultVisibility.value,
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                ) {
                    Text(
                        text = resultTextState.value,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = binaryTextColor,
                        textAlign = TextAlign.Center,
                        lineHeight = TextUnit(45f, type = TextUnitType.Sp),
                        maxLines = 3,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(0.8f)
                    )
                }

            }
            Keyboard(
                screenState = currentState.value,
                buttons = keyboard,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )

        }
    }
}

