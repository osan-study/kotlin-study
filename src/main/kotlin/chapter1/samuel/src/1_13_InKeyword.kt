fun main() {
    var percent = 35
    println("persent: $percent")
    println("percent in 1..100: ${percent in 1..100}")
    println("0 <= percent && percent <= 100: ${0 <= percent && percent <= 100}")

    val values = 1..3
    for (value in values) {
        println("iteration $value")
    }

    val v = 2
    if (v in values) {
        println("$v is in the range of values")
    }

    println("'t' in \"Kotlin\": ${'t' in "Kotlin"}")
    println("'a' in \"Kotlin\": ${'a' in "Kotlin"}")

    println("isDigit('a'): ${isDigit('a')}")
    println("isDigit('5'): ${isDigit('5')}")
    println("notDigit('z'): ${notDigit('z')}")

    inDoubleRange(0.9999)
    inDoubleRange(5.0)
    inDoubleRange(10.0)
    inDoubleRange(10.00001)

    println("\"ab\" in \"aa\"..\"az\": ${"ab" in "aa".."az"}")
    println("\"ba\" in \"aa\"..\"az\": ${"ba" in "aa".."az"}")

}

fun isDigit(ch: Char) = ch in '0'..'9'

fun notDigit(ch: Char) = ch !in '0'..'9'

fun inDoubleRange(n: Double) {
    val r = 1.0..10.0
    println("$n in $r? ${n in r}")
}