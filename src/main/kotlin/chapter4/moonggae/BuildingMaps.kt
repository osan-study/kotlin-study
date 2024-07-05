package chapter4.moonggae

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::groupBy)
    runExample(::associateWith)
    runExample(::associateBy)
}

data class Person(
    val name: String,
    val age: Int
)

val names = listOf(
    "Alice", "Arthricia",
    "Bob", "Bill", "Birdperson", "Charlie",
    "Crocubot", "Franz", "Revolio"
)

val ages = listOf(
    21, 15, 25, 25, 42, 21,
    42, 21, 33
)

val people: List<Person> = names.zip(ages, ::Person)

fun groupBy() {
    val map: Map<Int, List<Person>> = people.groupBy(Person::age)
    println("map:")
    println(map)
}

fun associateWith() {
    val map = people.associateWith { it.name }
    println("map:")
    println(map)
}

fun associateBy() {
    val map = people.associateBy { it.name }
    println("map:")
    println(map)
}