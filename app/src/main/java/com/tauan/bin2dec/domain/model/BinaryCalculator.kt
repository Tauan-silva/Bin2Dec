package com.tauan.bin2dec.domain.model

import com.tauan.bin2dec.domain.Converter
import com.tauan.bin2dec.domain.interfaces.CalculatorInterface
import kotlin.math.abs


class BinaryCalculator : CalculatorInterface<BinaryNumber> {

    override fun add(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number)
        val decimal2 = Converter.binaryToDecimal(number1)

        return Converter.decimalToBinary(decimal1 + decimal2)
    }

    override fun sub(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number)
        val decimal2 = Converter.binaryToDecimal(number1)

        return Converter.decimalToBinary(abs(decimal1 - decimal2))
    }

    override fun multiple(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number)
        val decimal2 = Converter.binaryToDecimal(number1)

        return Converter.decimalToBinary(decimal1 * decimal2)
    }

    override fun div(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number)
        val decimal2 = Converter.binaryToDecimal(number1)

        return Converter.decimalToBinary(abs(decimal1 / decimal2))
    }
}