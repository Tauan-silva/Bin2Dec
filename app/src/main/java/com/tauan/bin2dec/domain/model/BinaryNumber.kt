package com.tauan.bin2dec.domain.model

import kotlin.properties.Delegates

class BinaryNumber(value: String) {

    private val calculator = BinaryCalculator()

    private var ownValue by Delegates.notNull<Long>()


    init {
        if (!isValidNumber(value)) {
            throw IllegalArgumentException("It is not a binary number valid")
        } else {
            ownValue = value.toLong()
        }
    }

    private fun isValidNumber(value: String): Boolean {
        var isValid = true
        for (number in value) {
            if (number != '0' && number != '1') {
                isValid = false
                break
            }
        }
        return isValid && value.isNotEmpty()
    }

    fun plus(value: BinaryNumber): BinaryNumber {
        return calculator.add(this, value)
    }

    fun sub(value: BinaryNumber): BinaryNumber {
        return calculator.sub(this, value)
    }

    fun multiple(value: BinaryNumber): BinaryNumber {
        return calculator.multiple(this, value)
    }

    fun div(value: BinaryNumber): BinaryNumber {
        return calculator.div(this, value)
    }

    override fun toString(): String {
        return ownValue.toString()
    }
}