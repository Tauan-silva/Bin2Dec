package com.tauan.bin2dec.domain

import kotlin.math.pow

object Converter {

    fun binaryToDecimal(binaryString: String): Int {
        var decimal = 0

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
}