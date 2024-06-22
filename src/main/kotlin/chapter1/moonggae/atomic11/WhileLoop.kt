package chapter1.moonggae.atomic11

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::whileLoop)
    runExample(::doWhileLoop)
    runExample(::assignmentOperators)
    runExample(::incrementOperator)
}

fun condition(i: Int) = i < 100
fun whileLoop() {
    var i = 0
    while (condition(i)) {
        print(".")
        i += 10
    }
}

fun doWhileLoop() {
    var i = 0
    do {
        print(".")
        i += 10
    } while (condition(i))
}

fun assignmentOperators() {
    var n = 10
    val d = 3
    print(n)

    while (n > d) {
        n -= d
        print(" - $d")
    }
    println(" = $n")
    var m = 10
    print(m)
    m %= d
    println(" % $d = $m")
}

fun incrementOperator() {
    var i = 0
    while (i < 4) {
        print(".")
        i++
    }
}