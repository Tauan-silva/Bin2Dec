package com.tauan.bin2dec.domain.interfaces

interface NumberSystem {

    fun isValidNumber(value: String): Boolean
    fun plus(value: NumberSystem): NumberSystem
    fun sub(value: NumberSystem): NumberSystem
    fun multiple(value: NumberSystem): NumberSystem
    fun div(value: NumberSystem): NumberSystem

}