package com.tauan.bin2dec.domain.model

import com.tauan.bin2dec.domain.interfaces.NumberSystem
import kotlin.properties.Delegates

class BinaryNumber(value: String) : NumberSystem {

    private val calculator = BinaryCalculator()
    var ownValue by Delegates.notNull<Long>()
        private set

    init {
        if (!isValidNumber(value)) {
            throw IllegalArgumentException("It is not a binary number valid")
        } else {
            ownValue = value.toLong()
        }
    }

    override fun isValidNumber(value: String): Boolean {
        var isValid = true
        for (number in value) {
            if (number != '0' && number != '1') {
                isValid = false
                break
            }
        }
        return isValid
    }

    override fun plus(value: NumberSystem): NumberSystem {
//        return when (value) {
//            is BinaryNumber -> {
//                val result = calculator.add(this, value)
//                result
//            }
//            is OctalNumber -> {
//
//                val result = calculator.add(this)
//                result
//            }
//        }
        TODO("Not yet implemented")
    }

    override fun sub(value: NumberSystem): NumberSystem {
        TODO("Not yet implemented")
    }

    override fun multiple(value: NumberSystem): NumberSystem {
        TODO("Not yet implemented")
    }

    override fun div(value: NumberSystem): NumberSystem {
        TODO("Not yet implemented")
    }
}