
interface ZI {
    fun f(): String
    fun g(): String
}

open class ZIOpen : ZI {
    override fun f(): String = "ZIOpen.f()"
    override fun g(): String = "ZIOpen.g()"
}

class ZICompanion {
    companion object: ZIOpen()
    fun u() = "${f()} ${g()}"
}

class ZICompanionInheritance {
    companion object: ZIOpen() {
        override fun g(): String = "ZICompanionInheritance.g()"
        fun h() = "ZICompanionInheritance.h()"
    }
    fun u() = "${f()} ${g()} ${h()}"
}

class ZIClass {
    companion object: ZI {
        override fun f(): String = "ZIClass.f()"
        override fun g(): String = "ZIClass.g()"
    }
    fun u() = "${f()} ${g()}"
}

fun main() {
    println("ZIClass.f(): ${ZIClass.f()}")
    println("ZIClass.g(): ${ZIClass.g()}")
    println("ZIClass().u(): ${ZIClass().u()}")
    println("ZICompanion.f(): ${ZICompanion.f()}")
    println("ZICompanion.g(): ${ZICompanion.g()}")
    println("ZICompanion().u(): ${ZICompanion().u()}")
    println("ZICompanionInheritance.f(): ${ZICompanionInheritance.f()}")
    println("ZICompanionInheritance.g(): ${ZICompanionInheritance.g()}")
    println("ZICompanionInheritance().u(): ${ZICompanionInheritance().u()}")
}