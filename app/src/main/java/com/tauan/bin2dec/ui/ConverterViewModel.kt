package com.tauan.bin2dec.ui

import androidx.lifecycle.ViewModel
import com.tauan.bin2dec.domain.Converter
import com.tauan.bin2dec.domain.model.BinaryNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel : ViewModel() {

    private val _mutableScreenState = MutableStateFlow(ScreenState.DAY)
    val screenState = _mutableScreenState.asStateFlow()

    private var _binaryTextState = MutableStateFlow("")
    val binaryTextState = _binaryTextState.asStateFlow()

    private var _resultTextState = MutableStateFlow("")
    val resultTextState = _resultTextState.asStateFlow()

    private var _resultVisibility = MutableStateFlow(false)
    val resultVisibility = _resultVisibility.asStateFlow()

    private var _keyboardCalculatorVisibility = MutableStateFlow(false)
    val keyboardCalculatorVisibility = _keyboardCalculatorVisibility.asStateFlow()

    private fun clear(): String {
        return ""
    }

    fun onKeyPressed(newValue: String) {
        if (_resultVisibility.value) {
            _resultVisibility.value = false
        }
        _binaryTextState.value = _binaryTextState.value + newValue
    }

    fun onBackPressed() {
        if (_resultVisibility.value) {
            _resultTextState.value = dropLast(_resultTextState.value)
            if (_resultTextState.value.isEmpty()) {
                _binaryTextState.value = clear()
                _resultVisibility.value = false
            }
        } else {
            _binaryTextState.value = dropLast(_binaryTextState.value)
        }
    }

    fun onClearPressed() {
        _binaryTextState.value = ""
        _resultTextState.value = ""
        _resultVisibility.value = false
    }

    fun onEqualPressed() {
        _resultVisibility.value = !_resultVisibility.value
        convert()
    }

    private fun dropLast(string: String): String {
        return string.dropLast(1)
    }

    private fun convert() {
        val binaryNumber = BinaryNumber(_binaryTextState.value)
        val result = Converter.binaryToDecimal(binaryNumber)
        _resultTextState.value = result.toString()
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