package chapter1.moonggae.atomic06

fun multiplyByTow(x: Int): Int {
    println("Inside multiplyByTow")
    return x * 2
}

fun main() {
    val r = multiplyByTow(5)
    println(r)
}