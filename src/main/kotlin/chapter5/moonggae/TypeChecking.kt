package chapter5.moonggae.type


val Any.name
    get() = this::class.simpleName

sealed class Shape {
    abstract fun draw(): String
}

class Circle : Shape() {
    override fun draw() = "$name: Draw"
}

class Square : Shape() {
    override fun draw() = "$name: Draw"
}

class Triangle : Shape() {
    override fun draw() = "$name: Draw"
}

fun Shape.rotate(): String = "$name: " + when(this) {
    is Circle -> ""
    is Square -> "rorate"
    is Triangle -> "rorate"
}


fun main() {
    val shapes = listOf(Circle(), Square(), Triangle())
    shapes.forEach { println(it.draw()) }
    shapes.forEach { println(it.rotate()) }
}