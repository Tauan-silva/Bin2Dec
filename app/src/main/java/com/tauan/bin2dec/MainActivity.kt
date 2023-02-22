package com.tauan.bin2dec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tauan.bin2dec.ui.ConverterViewModel
import com.tauan.bin2dec.ui.compose.ConverterScreen
import com.tauan.bin2dec.ui.theme.Bin2DecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bin2DecTheme {
                val viewModel = ConverterViewModel()
                ConverterScreen(
                    viewModel = viewModel,
                    modifier = Modifier
                        .width(320.dp)
                        .height(520.dp)
                )
            }

        }
    }
}
