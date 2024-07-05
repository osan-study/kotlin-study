package chapter4.moonggae

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::zipper)
    runExample(::zipAndTransform)
    runExample(::flatten)
    runExample(::flatMap)
}

fun zipper() {
    val girls = listOf("수진", "혜진", "지연")
    val boys = listOf("민준", "지훈", "재현", "승우")

    println(girls)
    println(boys)
    println("girls.zip(boys): ${girls.zip(boys)}")
}


fun zipAndTransform() {
    val names = listOf("후라이드", "양념", "반반", "다리콤보", "날개콤보")
    val prices = listOf(10_000, 11_000, 11_500)

    val cheapChickens = names.zip(prices, ::Chicken)
    println("cheapChickens: $cheapChickens")

    println("names.zipWithNext(): ${names.zipWithNext()}")
}

fun flatten() {
    val list = listOf(
        listOf(1, 2),
        listOf(4, 5),
        listOf(7, 8),
    )

    println("list.flatten(): ${list.flatten()}")
}


fun flatMap() {
    class Book(
        val title: String,
        val authors: List<String>
    )

    val books = listOf(
        Book("1984", listOf("George Orwell")),
        Book("Ulysses", listOf("James Joyce"))
    )
    println("books.map { it.authors }.flatten(): ${books.map { it.authors }.flatten()}")
    println("books.flatMap { it.authors }: ${books.flatMap { it.authors }}")
}