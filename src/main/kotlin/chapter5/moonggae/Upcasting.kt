package chapter5.moonggae

interface Shape {
    fun draw(): String
    fun erase(): String
}

class Circle: Shape {
    override fun draw(): String = "Circle.draw"
    override fun erase(): String = "Circle.erase"
}

class Square: Shape {
    override fun draw(): String = "Square.draw"
    override fun erase(): String = "Square.erase"
    fun color() = "Square.color()"
}

class Triangle: Shape {
    override fun draw(): String = "Triangle.draw"
    override fun erase(): String = "Triangle.erase"
    fun rotate() = "Triangle.rotate()"
}

fun show(shape: Shape) {
    println("Show: ${shape.draw()}")
}

fun main() {
    // 자동 타입 캐스팅: val shapes: List<Shape>
    val shapes = listOf(Circle(), Square(), Triangle())
    shapes.forEach(::show)
    shapes.forEach {
        when (it) { // 스마트 캐스트
            is Square -> println(it.color())
            is Triangle -> println(it.rotate())
        }
    }
}