enum class Level {
    Overflow, High, Medium, Low, Empty
}

enum class Direction(val notation: String) {
    North("N"), South("S"), West("W"), East("E");
    val opposite: Direction
        get() = when (this) {
            North -> South
            South -> West
            West -> East
            East -> North
        }
}

fun main() {
    println("Level.Medium.toString() == \"Medium\": ${Level.Medium.toString() == "Medium"}")
    println("Level.Medium.ordinal == 2: ${Level.Medium.ordinal == 2}")

    println("Direction.North.toString() == \"North\": ${ Direction.North.toString() == "North"}")
    println("Direction.North.notation == \"N\": ${ Direction.North.notation == "N"}")
    println("Direction.North.opposite == \"Direction.South\": ${ Direction.North.opposite == Direction.South}")

}