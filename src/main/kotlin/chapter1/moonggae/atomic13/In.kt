package chapter1.moonggae.atomic13

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::membershipInRange)
    runExample(::membershipUsingBounds)
    runExample(::iterationVsMembership)
    runExample(::inString)
    runExample(::runCharRange)
    runExample(::runFloatingPointRange)
    runExample(::stringRange)
}

fun membershipInRange() {
    val percent = 35
    println(percent in 1..100)
}

fun membershipUsingBounds() {
    val percent = 35
    println(0 <= percent && percent <= 100)
}

fun iterationVsMembership() {
    val values = 1..3
    for (v in values) {
        println("iteration $v")
    }

    val v = 2
    if (v in values)
        println("$v is a member of $values")
}

fun inString() {
    println('t' in "Kotlin")
    println('a' in "Kotlin")
}

fun runCharRange() {
    fun isDigit(c: Char) = c in '0'..'9'
    fun notDigit(c: Char) = c !in '0'..'9'

    println(isDigit('a'))
    println(isDigit('5'))
    println(notDigit('z'))
}

fun runFloatingPointRange() {
    fun inFloatingRange(n: Double) {
        val r = 1.0..10.0
        println("$n in $r? ${n in r}")
    }

    inFloatingRange(0.9999999999999999)
    inFloatingRange(5.0)
    inFloatingRange(10.0)
    inFloatingRange(10.000000000000001)
}

fun stringRange() {
    println("ab" in "aa".."az")
    println("ba" in "aa".."az")
}