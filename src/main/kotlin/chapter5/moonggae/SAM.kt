package chapter5.moonggae

fun interface Adder {
    fun add(number1: Int, number2: Int): Int
    fun add2() = 4 // 구현된 함수 정의 가능
}

class Calculator(
    val adder: Adder
) {
    val add = adder::add
}

fun main() {
    val adder = Adder { number1: Int, number2: Int -> number1 + number2 }

    val calc1 = Calculator(adder)
    val calc2 = Calculator { number1: Int, number2: Int -> number1 + number2 }

    println("calc1.adder.add(1, 1): ${calc1.adder.add(1, 1)}")
    println("calc2.add(1, 1): ${calc2.add(1, 1)}")
}