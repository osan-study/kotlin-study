package chapter5.moonggae

interface A {
    fun callName() = "A"
    val numA: Double
        get() = 1.1
}

interface B {
    fun callName() = "B"
    val numB: Double
        get() = 2.2
}

class C: A, B {
    // 시그니처가 같은 멤버가 있을때 이를 처리하지 않으면 오류 발생
    override fun callName() = super<A>.callName()
}

fun main() {
    val c = C()
    println("c.callName(): ${c.callName()}")
    println("c.numA: ${c.numA}")
    println("c.numB: ${c.numB}")
}