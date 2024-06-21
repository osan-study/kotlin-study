package chapter2.moonggae.atomic29

import atomictest.eq

fun main() {
    val first = mutableListOf(1)
    val second: List<Int> = first
    second eq listOf(1)
    first += 2
    // second sees the change:
    second eq listOf(1, 2)
}