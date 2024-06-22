package chapter2.moonggae.atomic29

import atomictest.capture


fun main() {
    capture {
        "$1.9".toDouble()
    } eq "NumberFormatException: " +
            """For input string: "$1.9""""
}