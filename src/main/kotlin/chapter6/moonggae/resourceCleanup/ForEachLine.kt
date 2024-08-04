package chapter6.moonggae.resourceCleanup

import atomictest.*
import chapter6.moonggae.check.DataFile

fun main() {
    DataFile("Results.txt").forEachLine {
        if (it.startsWith("#"))
            trace("$it")
    }
    trace eq "# ok"
}