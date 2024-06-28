val alpha = mapOf(
    1 to "a",
    2 to "b",
    3 to "c",
    4 to "d",
    5 to "e",
    6 to "f",
    7 to "g",
    8 to "h",
    9 to "i",
    10 to "j",
    11 to "k",
    12 to "l",
    13 to "m",
    14 to "n",
    15 to "o",
    16 to "p",
    17 to "q",
    18 to "r",
    19 to "s",
    20 to "t",
    21 to "u",
    22 to "v",
    23 to "w",
    24 to "x",
    25 to "y",
    26 to "z"
)

fun findAlpha(i: Int): String =
    when(i) {
        1 -> "a"
        2 -> "b"
        else -> alpha.getValue(i)
    }

fun main() {
    println("findAlpha(1): ${findAlpha(1)}")
    println("findAlpha(10): ${findAlpha(10)}")
    println("findAlpha(15): ${findAlpha(15)}")
    println("findAlpha(20): ${findAlpha(20)}")

    // 나머지 예제는 trace 등의 자체 정의함수를 사용하여 작성하지 않았음

}