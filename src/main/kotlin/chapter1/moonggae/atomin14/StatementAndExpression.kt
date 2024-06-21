package chapter1.moonggae.atomin14

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::unitReturnType)
    runExample(::postfixVsPrefix)
}

fun unitReturnType() {
    fun unitFun() = Unit
    println(unitFun())
    val u1 = println(42)
    println(u1)
    val u2 = println(0)
    println(u2)
}

fun postfixVsPrefix() {
    var i = 10
    println(i++)
    println(i)
    var j = 20
    println(++j)
    println(j)
}