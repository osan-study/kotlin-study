package chapter6.moonggae.check

import atomictest.*

data class Month(val monthNumber: Int) {
    init {
        require(monthNumber in 1..12) {
            "Month out of range: $monthNumber"
        }
    }
}

fun main() {
    Month(1) eq "Month(monthNumber=1)"
    capture { Month(13) } eq
            "IllegalArgumentException: " +
            "Month out of range: 13"
}