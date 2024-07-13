
interface Shape {
    fun draw(): String
    fun erase(): String
}

class Circle : Shape {
    override fun draw() = "Circle.draw"
    override fun erase() = "Circle.erase"
}

class Rectangle : Shape {
    override fun draw() = "Rectangle.draw"
    override fun erase() = "Rectangle.erase"
    fun color() = "Rectangle.color"
}

class Triangle : Shape {
    override fun draw() = "Triangle.draw"
    override fun erase() = "Triangle.erase"
    fun rotate() = "Triangle.rotate"
}

fun show(shape: Shape) {
    println("Show: ${shape.draw()}")
}

fun main () {
    listOf(Circle(), Rectangle(), Triangle()).forEach(::show)
}