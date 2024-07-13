interface Base2 {
    fun f()
}

class Derived2 : Base2 {
    override fun f() {}
    fun g() {}
}

class Derived3 : Base2 {
    override fun f() {}
    fun h() {}
}

interface Creature

class Human : Creature {
    fun greeting() = "I'm Human"
}

class Dog3 : Creature {
    fun bark() = "Yip!"
}

class Alien1 : Creature {
    fun mobility() = "Three legs"
}

fun what(c: Creature): String =
    when (c) {
        is Human -> c.greeting()
        is Dog3 -> c.bark()
        is Alien1 -> c.mobility()
        else -> "Something else"
    }

class SmartCast1(val c: Creature) {
    fun contact() {
        when (c) {
            is Human -> c.greeting()
            is Dog3 -> c.bark()
            is Alien1 -> c.mobility()
        }
    }
}

class SmartCast2(var c: Creature) {
    fun contact() {
        when (val c = c) {
            is Human -> c.greeting()
            is Dog3 -> c.bark()
            is Alien1 -> c.mobility()
        }
    }
}

fun dogBarkUnsafe(c: Creature) {
    (c as Dog3).bark()
}

fun dogBarkUnsafe2(c: Creature): String {
    c as Dog3
    c.bark()
    return c.bark() + c.bark()
}

fun dogBarkSafe(c: Creature) =
    (c as? Dog3)?.bark() ?: "Not a Dog"


val group: List<Creature> = listOf(
    Human(), Human(), Dog3(), Alien1(), Dog3()
)

fun main() {
    val b1: Base2 = Derived2()
    b1.f()
//    b1.g()
    if(b1 is Derived2) {
        b1.g()
    }
    val b2: Base2 = Derived3()
    b2.f()
//    b2.h()
    if(b2 is Derived3) {
        b2.h()
    }

    val c: Creature = Human()
    println("what(c): ${what(c)}")
    println("what(Dog3()): ${what(Dog3())}")
    println("what(Alien1()): ${what(Alien1())}")
    class Who : Creature
    println("what(Who()): ${what(Who())}")

    println("dogBarkUnsafe(Dog3()): ${dogBarkUnsafe(Dog3())}")
    println("dogBarkUnsafe2(Dog3()): ${dogBarkUnsafe2(Dog3())}")

    try {
        println("dogBarkUnsafe(Human()): ${dogBarkUnsafe(Human())}())")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    println("dogBarkSafe(Dog3()): ${dogBarkSafe(Dog3())}")
    println("dogBarkSafe(Human()): ${dogBarkSafe(Human())}")

    val dog = group.find { it is Dog3 } as Dog3?
    println("dog?.bark(): ${dog?.bark()}")

    val humans1: List<Creature> = group.filter { it is Human }
    println("humans1.size: ${humans1.size}")
    val humans2: List<Creature> = group.filterIsInstance<Human>()
    println("humans1 == humans2: ${humans1 == humans2}")
}
