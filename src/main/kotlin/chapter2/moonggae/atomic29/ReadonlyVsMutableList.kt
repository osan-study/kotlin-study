package chapter2.moonggae.atomic29

import atomictest.trace

fun main() {
    val ints = listOf(5, 13, 9)
    // ints.add(11) // 'add()' not available
    for (i in ints) {
        if (i > 10) {
            trace(i)
        }
    }
    val chars = mutableListOf('a', 'b', 'c')
    chars.add('d') // 'add()' available
    chars += 'e'
    trace(chars)
    trace eq """
    13
    [a, b, c, d, e]
  """
}