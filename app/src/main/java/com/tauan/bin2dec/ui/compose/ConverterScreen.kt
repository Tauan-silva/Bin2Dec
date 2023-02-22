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
import androidx.compose.runtime.*
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
import com.tauan.bin2dec.ui.ConverterViewModel
import com.tauan.bin2dec.ui.ScreenState
import com.tauan.bin2dec.ui.theme.MyColors


@Composable
fun ConverterScreen(viewModel: ConverterViewModel, modifier: Modifier = Modifier) {

    val nightBrush = Brush.linearGradient(MyColors.nightColors)
    val dayBrush = Brush.linearGradient(MyColors.dayColors)

    var currentState by remember { mutableStateOf(viewModel.mutableScreenState.value) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (currentState == ScreenState.DAY) dayBrush else nightBrush),
    ) {
        val state = viewModel.mutableScreenState.collectAsState().value
        if (currentState != state) {
            currentState = state
        }
        Content(viewModel, currentState, modifier.align(Alignment.Center))
    }

}

@Composable
private fun Content(
    viewModel: ConverterViewModel, currentState: ScreenState, modifier: Modifier = Modifier
) {
    var binaryRemember by remember {
        mutableStateOf("")
    }

    var resultRemember by remember {
        mutableStateOf("")
    }

    var resultVisibility by remember {
        mutableStateOf(false)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 16.dp),
        modifier = modifier
    ) {
        val cardColor = if (currentState == ScreenState.DAY) Color.White else Color(0xFF060306)
        val binaryTextColor =
            if (currentState == ScreenState.NIGHT) Color.White else Color(0xFF060306)

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
                    visible = !resultVisibility, exit = slideOutVertically()
                ) {
                    Text(
                        text = binaryRemember,
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
                    visible = resultVisibility,
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                ) {
                    Text(
                        text = resultRemember,
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
            Keyboard(screenState = currentState, onKeyPressed = { key ->
                if (resultVisibility) {
                    resultVisibility = false
                }
                binaryRemember = viewModel.onKeyPressed(binaryRemember, key)
            }, onBackPressed = {
                if (resultVisibility) {
                    resultRemember = viewModel.dropLast(resultRemember)
                    if (resultRemember.isEmpty()) {
                        binaryRemember = viewModel.clear()
                        resultVisibility = false
                    }
                } else {
                    binaryRemember = viewModel.dropLast(binaryRemember)
                }


            }, onClearPressed = {
                binaryRemember = viewModel.clear()
                resultRemember = viewModel.clear()
                resultVisibility = false
            }, onEqualPressed = {
                resultVisibility = !resultVisibility
                resultRemember = viewModel.convert(binaryRemember)
            },

                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )

        }
    }
}

