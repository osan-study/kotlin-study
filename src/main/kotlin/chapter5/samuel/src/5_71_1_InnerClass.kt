
class Hotel(private val reception: String) {
    open inner class Room(val id: Int = 0) {
        fun callReception() = "Room $id calling $reception"
    }

    private inner class Closet : Room()
    fun closet(): Room = Closet()
}

class Fruit {
    fun changeColor(color: String) = "Fruit $color"
    fun absorbWater(amount: Int) {}
    inner class Seed {
        fun changeColor(color: String) ="Seed $color"
        fun germinate() {}
        fun whichThis() {
            println("this.name: ${this.name}")
            println("this@Seed.name: ${this@Seed.name}")
            println("this@Fruit.name: ${this@Fruit.name}")
        }
        inner class DNA {
            fun changeColor(color: String) {
                println("this@Seed.changeColor(color): ${this@Seed.changeColor(color)}")
                println("this@Fruit.changeColor(color): ${this@Fruit.changeColor(color)}")
            }
            fun plant() {
                germinate()
                absorbWater(10)
            }
            fun Int.grow() {
                println("this.name: ${this.name}")
                println("this@grow.name: ${this@grow.name}")
                println("this@DNA.name: ${this@DNA.name}")
                println("this@Seed.name: ${this@Seed.name}")
                println("this@Fruit.name: ${this@Fruit.name}")
            }
            fun Seed.plant() {}
            fun DNA.plant() {}
            fun whichThis() {
                println("this.name: ${this.name}")
                println("this@DNA.name: ${this@DNA.name}")
                println("this@Seed.name: ${this@Seed.name}")
                println("this@Fruit.name: ${this@Fruit.name}")
            }
        }
    }
}

fun Fruit.grow(amount: Int) {
    absorbWater(amount)
    println(changeColor("Red"))
}

fun Fruit.Seed.grow(n: Int) {
    germinate()
    println(changeColor("Green"))
}

fun Fruit.Seed.DNA.grow(n: Int) = n.grow()

fun main() {
    val nycHotel = Hotel("311")
    val room = nycHotel.Room(319)
    println("room.callReception(): ${room.callReception()}")
    val sfHotel = Hotel("0")
    val closet = sfHotel.closet()
    println("closet.callReception(): ${closet.callReception()}")

    val fruit = Fruit()
    print("fruit.grow(4): ")
    fruit.grow(4)

    val seed = fruit.Seed()
    print("seed.grow(9): ")
    seed.grow(9)

    print("seed.whichThis(): ")
    seed.whichThis()

    val dna = seed.DNA()
    print("dna.plant(): ")
    dna.plant()
    print("dna.grow(5): ")
    dna.grow(5)
    print("dna.whichThis(): ")
    dna.whichThis()
    print("dna.changeColor(\"Purple\"): ")
    dna.changeColor("Purple")
}