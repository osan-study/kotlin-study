
class Numbered2
private constructor(private val id: Int) {
    override fun toString() = "$id"
    companion object Factory {
        fun create(size: Int) = List(size) { Numbered2(it) }
    }
}

class CompanionInit {
    init {
        println("CompanionInit Constructor")
    }
    companion object {
        init {
            println("Companion Constructor")
        }
    }
}

fun main() {
    println("Numbered2.create(0): ${Numbered2.create(0)}")
    println("Numbered2.create(5): ${Numbered2.create(5)}")

    println("Before")
    CompanionInit()
    println("After")
    CompanionInit()
    println("After 2")
    CompanionInit()
    println("After 3")
}