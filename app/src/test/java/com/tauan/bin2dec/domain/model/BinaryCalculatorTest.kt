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

        assertThat(result.toString()).isEqualTo("101")
    }

    @Test
    fun `should return a BinaryNumber with value 1010 when subtracts 1100 to 10`() {

        val binaryNumber1 = BinaryNumber("1100")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.sub(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("1010")
    }

    @Test
    fun `should return a BinaryNumber with value 1010 when subtracts 10 to 1100`() {

        val binaryNumber1 = BinaryNumber("10")
        val binaryNumber2 = BinaryNumber("1100")
        val calculator = BinaryCalculator()

        val result = calculator.sub(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("1010")
    }

    @Test
    fun `should return a BinaryNumber with value 0 when passing same values`() {

        val binaryNumber1 = BinaryNumber("1100")
        val binaryNumber2 = BinaryNumber("1100")
        val calculator = BinaryCalculator()

        val result = calculator.sub(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("0")
    }

    @Test
    fun `should return a BinaryNumber with value 1010 when multiples 101 to 10`() {

        val binaryNumber1 = BinaryNumber("101")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.multiple(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("1010")
    }

    @Test
    fun `should return a BinaryNumber with value 101 when divides 1010 to 10`() {

        val binaryNumber1 = BinaryNumber("1010")
        val binaryNumber2 = BinaryNumber("10")
        val calculator = BinaryCalculator()

        val result = calculator.div(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("101")
    }

    @Test
    fun `should return a BinaryNumber with value 0 when divides 1010 to 10100`() {

        val binaryNumber1 = BinaryNumber("1010")
        val binaryNumber2 = BinaryNumber("10100")
        val calculator = BinaryCalculator()

        val result = calculator.div(binaryNumber1, binaryNumber2)

        assertThat(result.toString()).isEqualTo("0")
    }

}