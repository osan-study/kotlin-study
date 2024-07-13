
class WithCompanion {
    companion object{
        val i = 3
        fun f() = i * 3
    }
    fun g() = i + f()
}

fun WithCompanion.Companion.h() = f() * i

class WithNamed {
    companion object Named {
        fun s() = "from Named"
    }
}

class WithDefault {
    companion object {
        fun s() = "from Default"
    }
}

class WithObjectProperty {
    companion object {
        private var n: Int = 0
    }
    fun increment() = ++n
}

class CompanionObjectFunction {
    companion object {
        private var n: Int = 0
        fun increment() = ++n
    }
}


fun main() {
    val wc = WithCompanion()
    println("wc.g(): ${wc.g()}")
    println("WithCompanion.i: ${WithCompanion.i}")
    println("WithCompanion.f(): ${WithCompanion.f()}")
    println("WithCompanion.h(): ${WithCompanion.h()}")

    println("WithNamed.s(): ${WithNamed.s()}")
    println("WithNamed.Named.s(): ${WithNamed.Named.s()}")
    println("WithDefault.s(): ${WithDefault.s()}")
    println("WithDefault.Companion.s(): ${WithDefault.Companion.s()}")

    val a = WithObjectProperty()
    val b = WithObjectProperty()
    println("a.increment(): ${a.increment()}")
    println("b.increment(): ${b.increment()}")
    println("a.increment(): ${a.increment()}")

    println("CompanionObjectFunction.increment(): ${CompanionObjectFunction.increment()}")
    println("CompanionObjectFunction.increment(): ${CompanionObjectFunction.increment()}")
}