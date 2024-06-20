package chapter1.moonggae.atomic08

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::stringTemplates)
    runExample(::stringConcatenation)
    runExample(::expressionInTemplate)
    runExample(::tripleQuotes)
}

fun stringTemplates() {
    val answer = 42
    println("answer is $answer!")
    println("printing a $1")
}

fun stringConcatenation() {
    val s = "hi\n"
    val n = 11
    val d = 3.14
    println("first: " + s + "second: " + n + ", third: " + d)
}

fun expressionInTemplate() {
    val condition = true
    println(
        "${if (condition) 'a' else 'b'}"
    )
    val x = 11
    println("$x + 4 = ${x + 4}")
}

fun tripleQuotes() {
    val s = "value"
    println("s = \"$s\".")
    println("""s = "$s".""") // 큰 따옴표
}