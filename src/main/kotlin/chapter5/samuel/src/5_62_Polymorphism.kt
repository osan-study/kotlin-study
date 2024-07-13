
open class Pet {
    open fun speak() = "pet"
}

class Dog2 : Pet() {
    override fun speak() = "Bark!"
}

class Cat2 : Pet() {
    override fun speak() = "meow!"
}

fun talk(pet: Pet) = pet.speak()

abstract class Character(val name: String) {
    abstract fun play(): String
}

interface Fighter {
    fun fight() = "Fight!"
}

interface Magician {
    fun doMagic() = "Magic!"
}

class Warrior : Character("Warrior"), Fighter {
    override fun play() = fight()
}

open class Elf(name: String = "Elf") : Character(name), Magician {
    override fun play() = doMagic()
}

class FightingElf : Elf("FightingElf"), Fighter {
    override fun play() = super.play() + fight()
}

fun Character.playTurn() = "name : ${play()}"

fun main() {
    println("talk(Dog2()): ${talk(Dog2())}")
    println("talk(Cat2()): ${talk(Cat2())}")

    val characters: List<Character> = listOf(Warrior(), Elf(), FightingElf())
    println("characters.forEach { it.playTurn() }: ${characters.forEach { println(it.playTurn()) }}")
}