package chapter1.moonggae.atomic06

fun sayHello() {
    println("Hello!")
}

fun sayGoodbye(): Unit { // Unit 생략 가능
    println("Goodbye!")
}

fun main() {
    sayHello()
    sayGoodbye()
}