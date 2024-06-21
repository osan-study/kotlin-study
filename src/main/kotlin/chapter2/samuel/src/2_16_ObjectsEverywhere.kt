fun main() {
    var r1 = IntRange(0, 10)
    var r2 = IntRange(5, 7)
    println("r1: $r1")
    println("r2: $r2")

    val r = IntRange(0, 10)
    println("r: $r")
    println("r.sum(): ${r.sum()}")

    val s = "ABcD"
    println("s: $s")
    println("s.reversed(): ${s.reversed()}")
    println("s.lowercase(): ${s.lowercase()}")

    val str = "123"
    println("str: $str")
    println("str.toInt(): ${str.toInt()}")
    val i = 123
    println("i: $i")
    println("i.toString(): ${i.toString()}")

    val num = 1
    val den = 2
    println("num: $num")
    println("den: $den")
    println("fraction(num.toLong(), den.toLong()): ${fraction(num.toLong(), den.toLong())}")
}

fun fraction(numerator: Long, denom: Long) = numerator.toDouble() / denom