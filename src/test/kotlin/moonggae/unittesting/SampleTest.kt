package moonggae.unittesting

import chapter6.moonggae.unittest.allGood
import chapter6.moonggae.unittest.fortyTwo
import kotlin.test.*


class SampleTest {
    @Test
    fun testFortyTwo() {
        expect(42, "Incorrect,") { fortyTwo() }
    }
    @Test
    fun testAllGood() {
        assertTrue(allGood(), "Not good")
    }
}