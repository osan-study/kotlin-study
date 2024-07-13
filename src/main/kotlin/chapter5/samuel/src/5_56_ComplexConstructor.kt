class MyAlien(val name: String)

private var counter = 0

class Msg(text: String) {

    private val content: String

    init {
        counter += 10
        content = "[$counter] $text"
    }

    override fun toString() = content

}

fun main() {
    val alien = MyAlien("Samuel")
    println("alien.name: ${alien.name}")

    val m1 = Msg("Big ba-ba boom!")
    println("m1.toString(): ${m1.toString()}")
    val m2 = Msg("Bzzzzzt!")
    println("m2.toString(): ${m2.toString()}")

}