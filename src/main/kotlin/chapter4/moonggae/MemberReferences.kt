package chapter4.moonggae

import chapter1.moonggae.util.runExample
import chapter3.moonggae.toPrettyString

fun memberReferences() {
    println("chickenList.filter(Chicken::isFavorite):")
    println(chickenList.filter(Chicken::isFavorite).toPrettyString())

    println("chickenList.sortedWith(compareBy(Chicken::isFavorite, Chicken::price)):")
    println(chickenList.sortedWith(compareBy(Chicken::isFavorite, Chicken::price)).toPrettyString())
}

fun functionReferences() {
    println("chickenList.filter(Chicken::isRed).map { it.name }: ${chickenList.filter(Chicken::isRed).map { it.name }}")
}

fun constructorReference() {
    data class Student(
        val id: Int,
        val name: String
    )

    val names = listOf("Alice", "Bob")
    val students = names.mapIndexed { index, name ->
        Student(index, name)
    }

    println(students)
    println(names.mapIndexed(::Student))
}


fun main() {
    runExample(::memberReferences)
    runExample(::functionReferences)
    runExample(::constructorReference)
}