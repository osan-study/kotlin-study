package chapter2.moonggae.atomic29

import atomictest.eq

class NoBody

class SomeBody {
    val name = "Some Body"
}

class EveryBody {
    val all = listOf(SomeBody(), SomeBody(), SomeBody())
}

fun main() {
    val nb = NoBody()
    val sb = SomeBody()
    val eb = EveryBody()
}