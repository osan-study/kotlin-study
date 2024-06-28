import chapter3.HyunJunSon.enumerations

fun compute(input: Int): Pair<Int, String> =
    if (input > 5)
        Pair(input * 2, "High")
    else
        Pair(input * 2, "Low")


data class TestDes(
    val a: Int,
    val b: Int,
    val c: Int,
    val d: Int,
    val e: Int
)

fun main() {
    println("compute(7) == Pair(14, \"High\"): ${compute(7) == Pair(14, "High")}")
    println("compute(4) == Pair(8, \"Low\"): ${compute(4) == Pair(8, "Low")}")

    val (value, description) = compute(7)
    println("value: $value")
    println("description: $description")

    val t1 = TestDes(1, 2, 3, 4, 5)
    val (a, b, c, d, e) = t1
    println("a: $a, b: $a, b: $b, c: $c, d: $d, e: $e")

    val list = listOf(1, 2, 3, 4, 5)
    for((index, value) in list.withIndex()) {
        println("index: $index, value: $value")
    }
}