package chapter6.moonggae.resourceCleanup

import atomictest.eq
import chapter6.moonggae.check.DataFile

fun main() {
    DataFile("Results.txt").useLines { lines ->
        lines.filter { line ->
            "#" in line
        }.first()
    } eq "# ok"
}