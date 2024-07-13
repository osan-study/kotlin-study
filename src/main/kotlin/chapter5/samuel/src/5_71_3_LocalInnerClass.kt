fun interface Pet2 {
    fun speak(): String
}

object CreatePet {
    fun home() = " Home!"
    fun dog(): Pet2 {
        val say = "Bark!"
        class Dog : Pet2 {
            override fun speak() = say + home()
        }
        return Dog()
    }

    fun cat(): Pet2 {
        val emit = "meow"
        return object : Pet2 {
            override fun speak() = emit + home()
        }
    }

    fun hamster(): Pet2 {
        val squeak = "Squeak"
        return Pet2 { squeak + home() }
    }

}

fun main() {
    println("CreatePet.dog().speak(): ${CreatePet.dog().speak()}")
    println("CreatePet.cat().speak(): ${CreatePet.cat().speak()}")
    println("CreatePet.hamster().speak(): ${CreatePet.hamster().speak()}")
}