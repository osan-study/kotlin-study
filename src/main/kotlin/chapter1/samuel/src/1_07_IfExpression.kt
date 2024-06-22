fun main() {
    if (1 > 0)
        println("It's true")
    if (10 < 11) {
        println("10 < 11")
        println("ten is less than eleven")
    }

    val x: Boolean = 1 >= 1
    if (x) {
        println("x is true")
    }

    val n: Int = -11
    if (n > 0) {
        println("n is positive")
    } else {
        println("n is negative or Zero")
    }

    val m: Int = -11
    if (m > 0) {
        println("m is positive")
    } else if(m == 0) {
        println("m is Zero")
    } else {
        println("m is negative")
    }

    var o: Int = 0
    if(o != 0) {
        println("o is not zero")
    } else {
        println("o is zero")
    }

    val y: Boolean = false
    if(!y) {
        println("!y is true")
    }

    val num = 10
    val result = if (num > 100) 4 else 42
    println("num: $result")

    val b = 1
    println(trueOrFalse(b < 3))
    println(trueOrFalse(b >= 3))

    val l = 1
    println(oneOrTheOther(l == 1))
    println(oneOrTheOther(l == 2))
}

fun trueOrFalse(exp: Boolean): String {
    if (exp)
        return "exp is true"
    return "exp is false"
}

fun oneOrTheOther(exp: Boolean): String =
    if (exp) "exp is true" else "exp is false"