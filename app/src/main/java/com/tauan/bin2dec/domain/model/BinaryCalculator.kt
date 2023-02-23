package com.tauan.bin2dec.domain.model

import com.tauan.bin2dec.domain.Converter
import com.tauan.bin2dec.domain.interfaces.CalculatorInterface

class BinaryCalculator: CalculatorInterface<BinaryNumber> {

    override fun add(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number.ownValue.toString())
        val decimal2 = Converter.binaryToDecimal(number1.ownValue.toString())

        return Converter.decimalToBinary(decimal1 + decimal2)
    }

    override fun sub(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number.ownValue.toString())
        val decimal2 = Converter.binaryToDecimal(number1.ownValue.toString())

        return Converter.decimalToBinary(decimal1 - decimal2)
    }

    override fun multiple(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number.ownValue.toString())
        val decimal2 = Converter.binaryToDecimal(number1.ownValue.toString())

        return Converter.decimalToBinary(decimal1 * decimal2)
    }

    override fun div(number: BinaryNumber, number1: BinaryNumber): BinaryNumber {
        val decimal1 = Converter.binaryToDecimal(number.ownValue.toString())
        val decimal2 = Converter.binaryToDecimal(number1.ownValue.toString())

        return Converter.decimalToBinary(decimal1 / decimal2)
    }
}