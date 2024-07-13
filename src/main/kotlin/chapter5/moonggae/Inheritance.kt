package chapter5.moonggae

open class Character(
    val name: String,
    private var health: Int
) {
    fun displayInfo() {
        println("Name: $name, Health: $health")
    }

    open fun takeDamage(damage: Int) {
        health -= damage
        println("$name: -${damage} damage : $health")
    }

    fun isAlive(): Boolean {
        return health > 0
    }
}

class Warrior(
    name: String,
    health: Int,
    private val attackPower: Int
) : Character(name, health) {
    fun attack(target: Character) {
        println("$name: attacks ${target.name} +$attackPower")
        target.takeDamage(attackPower)
    }

    override fun takeDamage(damage: Int) {
        val reducedDamage = damage / 2
        super.takeDamage(reducedDamage)
    }
}

class Mage(
    name: String,
    health: Int,
    private val mana: Int
) : Character(name, health) {
    fun attack(target: Character) {
        val spellPower = mana / 5
        println("$name: attacks ${target.name} +$spellPower")
        target.takeDamage(spellPower)
    }

    override fun takeDamage(damage: Int) {
        val shieldedDamage = damage - (mana / 10)
        super.takeDamage(shieldedDamage)
    }
}

// 메인 함수
fun main() {
    val warrior = Warrior("Conan", 100, 20)
    val mage = Mage("Gandalf", 80, 50)

    warrior.displayInfo()
    mage.displayInfo()

    println("\nBattle begins!\n")

    while (warrior.isAlive() && mage.isAlive()) {
        warrior.attack(mage)
        println()
        mage.attack(warrior)
        println()
    }

    warrior.displayInfo()
    mage.displayInfo()
}