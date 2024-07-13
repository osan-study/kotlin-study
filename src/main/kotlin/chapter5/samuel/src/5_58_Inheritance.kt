open class Parent
class Child: Parent()
final class Single
class AnotherSingle

open class GreatApe {
    val weight = 100
    val age = 12
    protected var energy = 0
    open fun call() = "Hoo!"
    open fun eat() {
        energy += 10
    }
    fun climb(x: Int) {
        energy -= x
    }
    fun energyLevel() = "Energy: $energy"
}

open class Bonobo : GreatApe() {
    override fun call() = "Eep!"
    override fun eat() {
        energy += 10
        super.eat()
    }
    fun run() = "Bonobo run"
}

class Chimpanzee : GreatApe() {
    val additionalEnergy = 20
    override fun call() = "Yawp!"
    override fun eat() {
        energy += additionalEnergy
        super.eat()
    }
    fun jump() = "Chimp jump"
}

class BonoboB : Bonobo()

fun GreatApe.info() = "wt: $weight age: $age"
fun talk(ape: GreatApe): String {
    ape.eat()
    ape.climb(10)
    return "${ape.call()} ${ape.energyLevel()}"
}

fun main() {
    println("GreatApe().info(): ${GreatApe().info()}")
    println("Bonobo().info(): ${Bonobo().info()}")
    println("Chimpanzee().info(): ${Chimpanzee().info()}")
    println("BonoboB().info(): ${BonoboB().info()}")

    println("talk(GreatApe()): ${talk(GreatApe())}")
    println("talk(Bonobo()): ${talk(Bonobo())}")
    println("talk(Chimpanzee()): ${talk(Chimpanzee())}")
}