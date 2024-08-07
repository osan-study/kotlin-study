package chapter6.moonggae.unittest

import atomictest.capture
import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun fortyTwo() = 42

fun testFortyTwo(n: Int = 42) {
    assertEquals(
        expected = n,
        actual = fortyTwo(),
        message = "Incorrect,")
}

fun allGood(b: Boolean = true) = b

fun testAllGood(b: Boolean = true) {
    assertTrue(allGood(b), "Not good")
}

fun main() {
    testFortyTwo()
    testAllGood()
    capture {
        testFortyTwo(43)
    } contains
            listOf("expected:", "<43>",
                "but was", "<42>")
    capture {
        testAllGood(false)
    } contains listOf("Error", "Not good")
}