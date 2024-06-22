class Wombat
class Alien(name: String) {
    val greeting = "Poor $name!"
}
class MutableNameAlien(var name: String)
class FixedNAmeAlien(val name: String)
class AlienSpecies(
    val name: String,
    val eyes: Int,
    val hands: Int,
    val legs: Int
) {
    fun describe() = "$name with $eyes eyes, $hands hands and $legs legs"

    override fun toString(): String {
        return "AlienSpecies($name, $eyes, $hands, $legs)"
    }
}

fun main() {

    val wombat = Wombat()

    val alien = Alien("Samuel")
    println("alien.greeting: ${alien.greeting}")

    val alien1 = MutableNameAlien("Bug")
    val alien2 = FixedNAmeAlien("Samuel")
    println("alien1.name: ${alien1.name}")
    alien1.name = "Parasite"
    println("alien1.name = \"Parasite\"")
    println("alien1.name: ${alien1.name}")
    println("alien2.name: ${alien2.name}")

    val kevin = AlienSpecies("kevin", 2, 2, 2)
    val mortyJr = AlienSpecies("mortyJr", 2, 6, 2)
    println("kevin.describe(): ${kevin.describe()}")
    println("mortyJr.describe(): ${mortyJr.describe()}")
    println(kevin)
    println(mortyJr)
}