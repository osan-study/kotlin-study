package chapter1.moonggae.atomic10

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::runIsOpen1)
    runExample(::runIsOpen2)
    runExample(::runIsClosed)
    runExample(::evaluationOrder)
}
fun isOpen1(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours: $open - $closed")
    val status = if (hour in open..closed) true else false
    println("Status: $status")
}

fun runIsOpen1() {
    isOpen1(6)
}

fun isOpen2(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours: $open - $closed")
    val status = hour in open..closed
    println("Status: $status")
}

fun runIsOpen2() {
    isOpen2(6)
}

fun isClosed(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours: $open - $closed")
    val status = hour < open || hour > closed
    println("Status: $status")
}

fun runIsClosed() {
    isClosed(6)
}

fun evaluationOrder() {
    val sunny = true
    val hoursSleep = 6
    val exercise = false
    val temp = 55

    val happy1 = sunny && temp > 50 || // and 연산 실행 후 or 연산이 실행됨
            exercise && hoursSleep > 7
    println(happy1)

    val sameHappy1 = (sunny && temp > 50) ||
            (exercise && hoursSleep > 7)
    println(sameHappy1)

    val notSame =
        (sunny && temp > 50 || exercise) &&
                hoursSleep > 7
    println(notSame)
}