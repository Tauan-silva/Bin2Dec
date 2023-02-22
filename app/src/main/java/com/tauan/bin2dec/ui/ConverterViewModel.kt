package com.tauan.bin2dec.ui

import androidx.lifecycle.ViewModel
import com.tauan.bin2dec.domain.Converter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel : ViewModel() {

    private val _mutableScreenState = MutableStateFlow(ScreenState.DAY)
    val mutableScreenState = _mutableScreenState.asStateFlow()

    fun clear(): String {
        return ""
    }

    fun onKeyPressed(binaryString: String, newValue: String): String {
        return binaryString + newValue
    }

    fun dropLast(binaryString: String): String {
        return binaryString.dropLast(1)
    }

    fun convert(binaryString: String): String {
        val result = Converter.binaryToDecimal(binaryString)
        return result.toString()
    }

    fun changeTheme() {
        when (_mutableScreenState.value) {
            ScreenState.DAY -> {
                _mutableScreenState.value = ScreenState.NIGHT
            }
            else -> {
                _mutableScreenState.value = ScreenState.DAY
            }
        }
    }

}