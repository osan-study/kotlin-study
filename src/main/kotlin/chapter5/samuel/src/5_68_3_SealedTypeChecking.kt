

sealed class Shapes {
    fun draw() = "$name: Draw"
}

class Circles : Shapes()

class Squares : Shapes() {
    fun rotate() = "Squares: Rotate"
}

class Triangles : Shapes() {
    fun rotate() = "Triangles: Rotate"
}

fun turns(s: Shapes) =
    when(s) {
        is Circles -> ""
        is Squares -> s.rotate()
        is Triangles -> s.rotate()
    }


fun main() {
    val shapes = listOf(
        Circles(), Squares()
    )

    println("shapes.map { it.draw() }: ${shapes.map { it.draw() }}")
    println("shapes.map { turns(it) }: ${shapes.map { turns(it) }}")

}