package com.tauan.bin2dec

import com.google.common.truth.Truth.assertThat
import com.tauan.bin2dec.domain.Converter
import org.junit.Test

class ConverterTest {

    @Test
    fun given_BinaryToDecimal_when_Has10011AsParameter_then_ShouldReturn19() {
        val result = Converter.binaryToDecimal("10011")
        assertThat(result).isEqualTo(19)
    }

    @Test
    fun given_OthersNumberDifferentOf0or1_when_PassingAsParameterToBinaryToDecimal_then_ShouldReturn0() {

        val result = Converter.binaryToDecimal("10191")
        assertThat(result).isEqualTo(0)

    }
}