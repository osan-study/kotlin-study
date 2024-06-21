import atomictest.eq

fun main() {

    listOf(1) eq  "[1]"
    listOf("A", "B") eq "[A, B]"

    v("abc", 1.0, 2.0)
    v("abc", 1.0, 2.0, 3.0, 4.0)
    v("abc", 1.0, 2.0, 3.0, 4.0, 5.0, 6.0)

    sum(13, 27, 44) eq 84
    sum(1, 3, 5, 7, 9, 11) eq 36
    sum() eq 0

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    sum(*list.toIntArray()) eq 55
}

fun v(s: String, vararg d: Double) {}

fun sum(vararg numbers: Int): Int {
    var total = 0
    for (number in numbers) {
        total += number
    }
    return total
}