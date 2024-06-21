fun main() {
    val r = multiplyByTwo(5)
    println(r)
    sayHello()
    sayGoodbye()
    print(multiplyByThree(5))
}

fun multiplyByTwo(x: Int): Int {
    println("Inside multiplyByTwo")
    return x * 2
}

fun sayHello() {
    println("Hello")
}

fun sayGoodbye(): Unit {
    println("Goodbye")
}

// 식 본문
fun multiplyByThree(x: Int): Int = x * 3