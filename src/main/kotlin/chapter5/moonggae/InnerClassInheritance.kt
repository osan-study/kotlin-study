package chapter5.moonggae

import atomictest.*

open class Egg {
    private var yolk = Yolk()
    open inner class Yolk {
        init { println("Egg.Yolk()") }
        open fun f() { println("Egg.Yolk.f()") }
    }
    init { println("New Egg()") }
    fun insertYolk(y: Yolk) { yolk = y }
    fun g() { yolk.f() }
}

class BigEgg : Egg() {
    inner class Yolk : Egg.Yolk() {
        init { println("BigEgg.Yolk()") }
        override fun f() {
            println("BigEgg.Yolk.f()")
        }
    }
    init { insertYolk(Yolk()) }
}

fun main() {
    println("-- init bigEgg --")
    val bigEgg = BigEgg()
    println("-- call g() --")
    bigEgg.g()

//    trace eq """
//    Egg.Yolk()
//    New Egg()
//    Egg.Yolk()
//    BigEgg.Yolk()
//    BigEgg.Yolk.f()
//  """
}