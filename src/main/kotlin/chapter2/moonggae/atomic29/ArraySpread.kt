package chapter2.moonggae.atomic29

import atomictest.trace

fun main() {
    val array = intArrayOf(4, 5)      // [1]
    varargs("x", 1, 2, 3, *array, 6)  // [2]
    val list = listOf(9, 10, 11)
    varargs(
        "y", 7, 8, *list.toIntArray())  // [3]
    trace eq "1 2 3 4 5 6 x 7 8 9 10 11 y"
}