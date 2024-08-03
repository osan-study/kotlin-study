import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

fun fortyTwo() = 42

fun testFortyTwo(n: Int = 42) {
    assertEquals(
        expected = n,
        actual = fortyTwo(),
        message = "Incorrect, "
    )
}

fun allGood(b: Boolean = true) = b

fun testAllGood(b: Boolean = true) {
    assertTrue(allGood(b), "Not good")
}

fun <T> expect(
    expected: T,
    message: String?,
    block: () -> T
) {
    assertEquals(expected, block(), message)
}

fun testFortyTwo2(n: Int = 42) {
    expect(n, "Incorrect,") {fortyTwo()}
}

fun main() {
    testFortyTwo()
    testAllGood()

//    try {
//        testFortyTwo(43)
//    } catch (e: Exception){
//        e.printStackTrace()
//    }
//
//    try {
//        testAllGood(false)
//    } catch (e: Exception){
//        e.printStackTrace()
//    }

    testFortyTwo2()

//    try {
//        testFortyTwo2(43)
//    } catch (e: Exception){
//        e.printStackTrace()
//    }

    assertFails{ testFortyTwo2(43) }
//
//    try {
//        assertFails{ testFortyTwo2() }
//    } catch(e: Exception) {
//        e.printStackTrace()
//    }

    assertFailsWith<AssertionError> {
        testFortyTwo2(43)
    }

    try {
        assertFailsWith<AssertionError> {
            testFortyTwo2()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}