package com.tauan.bin2dec.domain

import com.tauan.bin2dec.domain.model.BinaryNumber
import kotlin.math.pow

object Converter {

    fun binaryToDecimal(binaryNumber: BinaryNumber): Int {
        var decimal = 0
        val binaryString = binaryNumber.toString()

        for ((position, index) in (binaryString.length - 1 downTo 0).withIndex()) {
            val digit = binaryString[index].toString().toInt()
            if (digit != 0 && digit != 1) {
                decimal = 0
                break
            }
            val value = digit * 2.0.pow(position.toDouble()).toInt()
            decimal += value
        }

        return decimal
    }

    fun decimalToBinary(decimal: Int): BinaryNumber {
        var mutableDecimal = decimal
        var binaryNumber = 0L
        var index = 1
        var remainder: Int

        while (mutableDecimal != 0) {
            remainder = mutableDecimal % 2
            mutableDecimal /= 2
            binaryNumber += remainder * index
            index *= 10
        }

        return BinaryNumber(binaryNumber.toString())
    }
}