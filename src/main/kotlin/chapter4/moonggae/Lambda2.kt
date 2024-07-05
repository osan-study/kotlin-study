package chapter4.moonggae

var sumResult: Int? = null

fun main() {
    val addNumbers: (Int) -> Unit = { sumResult = (sumResult ?: 0) + it }
    val isEven: (Int) -> Boolean = { it % 2 == 0 }

    (1..10)
        .filter(isEven)
        .forEach(addNumbers)

    println(sumResult)
}