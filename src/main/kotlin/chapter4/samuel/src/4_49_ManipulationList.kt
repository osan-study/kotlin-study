import kotlin.random.Random

data class Person(
    val name: String,
    val id: Int
)

enum class Suit {
    Spade, Club, Heart, Diamond
}

enum class Rank(val faceValue: Int) {
    Ace(1), Two(2), Three(3), Four(4), Five(5),
    Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
    Jack(10), Queen(10), King(10)
}

class Card(val rank: Rank, val suit: Suit) {
    override fun toString() = "$rank of ${suit}s"
}

val deck: List<Card> =
    Suit.values().flatMap { suit -> Rank.values().map { rank -> Card(rank, suit) } }

fun main() {
    val left = listOf("a", "b", "c", "d")
    val right = listOf("q", "r", "s", "t")

    println("left.zip(right).toString() == \"[(a, q), (b, r), (c, s), (d, t)]\": ${left.zip(right).toString() == "[(a, q), (b, r), (c, s), (d, t)]"}")
    println("left.zip(0..4).toString() == \"[(a, 0), (b, 1), (c, 2), (d, 3)]\": ${left.zip(0..4).toString() == "[(a, 0), (b, 1), (c, 2), (d, 3)]"}")
    println("(10..100).zip(right).toString() == \"[(10, q), (11, r), (12, s), (13, t)]\": ${(10..100).zip(right).toString() == "[(10, q), (11, r), (12, s), (13, t)]"}")

    val names= listOf("Sam", "Bob", "Jane")
    val ids = listOf(1234, 5678, 7878)
    println("names.zip(ids) { name, id -> Person(name, id)}.toString() == \"[Person(name=Sam, id=1234), Person(name=Bob, id=5678), Person(name=Jane, id=7878)]\": ${names.zip(ids) { name, id -> Person(name, id)}.toString() == "[Person(name=Sam, id=1234), Person(name=Bob, id=5678), Person(name=Jane, id=7878)]"}")

    val list = listOf('a', 'b', 'c', 'd')
    val listPair = listOf(Pair('a', 'b'), Pair('b', 'c'), Pair('c', 'd'))
    val listPair2 = listOf("ab", "bc", "cd")

    println("list.zipWithNext() == listPair: ${list.zipWithNext() == listPair}")
    println("list.zipWithNext { a, b ->\"\$a\$b\" } == listPair2: ${list.zipWithNext { a, b -> "$a$b" } == listPair2 }")

    val listFlatten = listOf(
        listOf(1, 2),
        listOf(3, 4),
        listOf(5, 6)
    )

    println("listFlatten.flatten().toString() == \"[1, 2, 3, 4, 5, 6]\": ${listFlatten.flatten().toString() == "[1, 2, 3, 4, 5, 6]"}")

    val intRange = 1..3

    println("intRange.map { a -> intRange.map { b -> a to b } }.toString() == \"[[(1, 1), (1, 2), (1, 3)], [(2, 1), (2, 2), (2, 3)], [(3, 1), (3, 2), (3, 3)]]\": ${intRange.map { a -> intRange.map { b -> a to b } }.toString() == "[[(1, 1), (1, 2), (1, 3)], [(2, 1), (2, 2), (2, 3)], [(3, 1), (3, 2), (3, 3)]]"}")
    println("intRange.map { a -> intRange.map { b -> a to b } }.flatten().toString() == \"[(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3)]\": ${intRange.map { a -> intRange.map { b -> a to b } }.flatten().toString() == "[(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3)]"}")
    println("intRange.flatMap { a -> intRange.map { b -> a to b } }.toString() == \"[(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3)]\": ${intRange.flatMap { a -> intRange.map { b -> a to b } }.toString() == "[(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3)]"}")


    val rand = Random(26)
    repeat(7) {
        println(deck.random(rand))
    }
}