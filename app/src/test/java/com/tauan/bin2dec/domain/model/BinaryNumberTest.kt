package com.tauan.bin2dec.domain.model

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class BinaryNumberTest {


    @Test
    fun `should throws IllegalArgumentException when receives some value different to 0 or 1 as parameter`() {
        val invalidValue = "101201"
        assertThrows(IllegalArgumentException::class.java) {
            BinaryNumber(invalidValue)
        }
    }

    @Test
    fun `plus() function should returns a value instance of BinaryNumber when receive a value with same instance`() {
        val binaryNumber = BinaryNumber("101110")
        val binaryNumberParameter = BinaryNumber("1010")

        val result = binaryNumber.plus(binaryNumberParameter)

        assertThat(result).isInstanceOf(BinaryNumber::class.java)
    }

}