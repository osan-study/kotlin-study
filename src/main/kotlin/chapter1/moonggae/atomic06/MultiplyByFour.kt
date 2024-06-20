package chapter1.moonggae.atomic06

fun multiplyByFour(x: Int) = x * 4 // 리턴 타입 추론

fun main() {
    val result = multiplyByFour(5)
    println(result)
    println("type of result is ${result::class.qualifiedName}")
}