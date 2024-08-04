package chapter6.moonggae.resourceCleanup

import atomictest.eq
import chapter6.moonggae.check.DataFile


fun main() {
    DataFile("Results.txt")
        .bufferedReader()
        .use { it.readLines().first() } eq
            "Results"
}