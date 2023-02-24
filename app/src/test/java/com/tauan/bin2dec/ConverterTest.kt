package com.tauan.bin2dec

import com.google.common.truth.Truth.assertThat
import com.tauan.bin2dec.domain.Converter
import com.tauan.bin2dec.domain.model.BinaryNumber
import org.junit.Test

class ConverterTest {

    @Test
    fun given_BinaryToDecimal_when_Has10011AsParameter_then_ShouldReturn19() {
        val binaryNumber = BinaryNumber("10011")
        val result = Converter.binaryToDecimal(binaryNumber)
        assertThat(result).isEqualTo(19)
    }

    @Test
    fun given_OthersNumberDifferentOf0or1_when_PassingAsParameterToBinaryToDecimal_then_ShouldReturn0() {
        val binaryNumber = BinaryNumber("10191")
        val result = Converter.binaryToDecimal(binaryNumber)
        assertThat(result).isEqualTo(0)

    }

    @Test
    fun given_11AsParameter_when_CallsFunctionDecimalToBinary_then_ShouldReturnsBinaryNumberObjectWith1011Value() {

        val parameter = 11

        val result = Converter.decimalToBinary(parameter)

        assertThat(result.toString()).isEqualTo("1011")

    }
}