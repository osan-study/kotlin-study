package chapter5.moonggae


class CompanionInit {
    companion object {
        init {
            println("Companion Constructor")
        }
    }
}

fun main() {
    println("Before")
    CompanionInit()
    println("After 1")
    CompanionInit()
    println("After 2")
    CompanionInit()
    println("After 3")
}