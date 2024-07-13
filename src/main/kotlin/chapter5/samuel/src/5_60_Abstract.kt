
abstract class WithProperty {
    abstract var x: Int
}

abstract class WithFunctions {
    abstract fun f(): Int
    abstract fun g(n: Double)
}

interface Redundant {
    abstract var x: Int
    abstract fun f(): Int
    abstract fun g(n: Double)
}

interface Removed {
    var x: Int
    fun f(): Int
    fun g(n: Double)
}

interface Parent2 {
    val ch: Char
    fun f(): Int
    fun g() = "ch = $ch; f() = ${f()}"
}

class Actual (
    override val ch: Char
): Parent2 {
    override fun f() = 17
}

class Other : Parent2 {
    override val ch: Char
        get() = 'B'
    override fun f() = 34
}

interface PropertyAccessor {
    val a: Int
        get() = 11
}

class Impl : PropertyAccessor

interface Ani
interface Mam: Ani
interface Aqua: Ani

class Dolphin : Mam, Aqua

interface A {
    fun f() = 1
    fun g() = "A.g"
    val n: Double
        get() = 1.1
}

interface B {
    fun f() = 2
    fun g() = "B.g"
    val n: Double
        get() = 2.1
}

class C : A, B {
    override fun f() = 0
    override fun g() = super<A>.g()
    override val n: Double
        get() = super<A>.n + super<B>.n
}

fun main() {

    println("Actual('A').g(): ${Actual('A').g()}")
    println("Other().g(): ${Other().g()}")

    println("Impl().a: ${Impl().a}")

    val c = C()
    println("c.f(): ${c.f()}")
    println("c.g(): ${c.g()}")
    println("c.n: ${c.n}")

}