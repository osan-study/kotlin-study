package chapter1.moonggae.atomic05

fun main() {
    val n = 1 + 1.2
    println(n)

    println("type of n is ${n::class.qualifiedName}")
}