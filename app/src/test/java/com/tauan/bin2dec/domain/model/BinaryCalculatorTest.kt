package com.tauan.bin2dec.domain.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BinaryCalculatorTest {


    @Test
    fun `should return a BinaryNumber with value 101 when add 11 to 10`() {

        val binaryNumber1 = BinaryNumber("11")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.add(binaryNumber1, binaryNumber2)

        assertThat(result.ownValue).isEqualTo(101L)
    }

    @Test
    fun `should return a BinaryNumber with value 1 when subtracts 1011 to 110101`() {

        val binaryNumber1 = BinaryNumber("1011")
        val binaryNumber2 = BinaryNumber("110101")
        val calculator = BinaryCalculator()

        val result = calculator.sub(binaryNumber1, binaryNumber2)

        assertThat(result.ownValue).isEqualTo(1000000L)
    }

    @Test
    fun `should return a BinaryNumber with value 1010 when multiples 101 to 10`() {

        val binaryNumber1 = BinaryNumber("101")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.multiple(binaryNumber1, binaryNumber2)

        assertThat(result.ownValue).isEqualTo(1010L)
    }

    @Test
    fun `should return a BinaryNumber with value 101 when divides 1010 to 10`() {

        val binaryNumber1 = BinaryNumber("1010")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.div(binaryNumber1, binaryNumber2)

        assertThat(result.ownValue).isEqualTo(101L)
    }
}