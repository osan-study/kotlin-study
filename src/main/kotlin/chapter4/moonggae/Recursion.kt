package chapter4.moonggae

import chapter1.moonggae.util.runExample


fun main() {
    runExample(::runFactorial)
    runExample(::callStack)
    runExample(::tailrecSum)
}


fun runFactorial() {
    fun factorial(n: Long): Long {
        if (n <= 1) return 1
        return n * factorial(n - 1)
    }

    println("factorial(3): ${factorial(3)}")
    println("factorial(10): ${factorial(10)}")
}

fun callStack() {
    fun illegalState() { throw IllegalStateException() }
    fun fail() = illegalState()

    try { fail() } catch (e: Exception) { e.printStackTrace() }
}

fun tailrecSum() {
    tailrec fun sum(
        n: Long,
        accumulator: Long
    ): Long =
        if (n == 0L) accumulator
        else sum(n - 1, accumulator + n)

    fun sum(n: Long) = sum(n, 0)

    println("sum(10000): ${sum(10000)}")
    println("sum(100000): ${sum(100000)}")
    println("sum(10000000): ${sum(10000000)}")
}