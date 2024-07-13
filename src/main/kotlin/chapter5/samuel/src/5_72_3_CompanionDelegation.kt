package chapter5.samuel.src

import ZI

class ZIClosed : ZI {
    override fun f() = "ZIClosed.f()"
    override fun g() = "ZIClosed.g()"
}

class ZIDelegation {
    companion object: ZI by ZIClosed()
    fun u() = "${f()} ${g()}"
}

class ZIDelegationInheritance {
    companion object: ZI by ZIClosed() {
        override fun g() = "ZIDelegationInheritance.g()"
        fun h() = "ZIDelegationInheritance.h()"
    }
    fun u() = "${f()} ${g()} ${h()}"
}

fun main() {
    println("ZIDelegation.f(): ${ZIDelegation.f()}")
    println("ZIDelegation.g(): ${ZIDelegation.g()}")
    println("ZIDelegation().u(): ${ZIDelegation().u()}")
    println("ZIDelegationInheritance.f(): ${ZIDelegationInheritance.f()}")
    println("ZIDelegationInheritance.g(): ${ZIDelegationInheritance.g()}")
    println("ZIDelegationInheritance().u(): ${ZIDelegationInheritance().u()}")
}