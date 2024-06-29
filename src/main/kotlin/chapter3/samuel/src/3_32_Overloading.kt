class Overloading() {
    fun f() = 0
    fun f(n: Int) = n + 2
}

class My {
    fun foo() = 0
}

fun My.foo() = 1            // 오버라이딩 되지 않음
fun My.foo(i: Int) = i + 2

fun f(n: Int = 0) = n + 373
//fun f() = f(0)

fun add(i: Int, j: Int) = i + j
fun addInt(i: Int, j: Int) = i + j
fun add(i: Double, j: Double) = i + j
fun addDouble(i: Double, j: Double) = i + j


fun main() {
    val o  = Overloading()
    println("o.f() == 0: ${o.f() == 0}")
    println("o.f(11) == 13: ${o.f(11) == 13}")
    println("My().foo() == 0: ${My().foo() == 0}")
    println("My().foo(1) == 3: ${My().foo(1) == 3}")
//    println("f() == 373: ${f() == 373}")
    println("f() == 373: ${f() == 373}")

    println("add(5, 6) == addInt(5, 6): ${add(5, 6) == addInt(5, 6)}")
    println("add(56.23, 44.77) == addDouble(56.23, 44.77): ${add(56.23, 44.77) == addDouble(56.23, 44.77)}")
}