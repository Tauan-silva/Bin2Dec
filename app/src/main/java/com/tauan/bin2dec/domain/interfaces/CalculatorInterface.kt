package com.tauan.bin2dec.domain.interfaces

interface CalculatorInterface<T> {

    fun add(number: T, number1: T): T
    fun sub(number: T, number1: T): T
    fun multiple(number: T, number1: T): T
    fun div(number: T, number1: T): T

}