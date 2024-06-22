package chapter1.moonggae.atomic12

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::repeatThreeTimes)
    runExample(::definingRanges)
    runExample(::sumUsingRange)
    runExample(::forWithRanges)
    runExample(::forWithCharRange)
    runExample(::indexIntoString)
    runExample(::addingToChar)
    runExample(::iterateOverString)
    runExample(::runHasChar)
    runExample(::repeatHi)
}

fun repeatThreeTimes() {
    for (i in 1..3) {
        println("Hey $i!")
    }
}

fun definingRanges() {
    val range1 = 1..10
    val range2 = 0 until 10
    println(range1)
    println(range2)
}

fun sumUsingRange() {
    var sum = 0
    for (n in 10..100) {
        sum += n
    }
    println("sum = $sum")
}

fun forWithRanges() {
    fun showRange(r: IntProgression) {
        for (i in r)  {
            print("$i ")
        }
        print("\t// $r")
        println()
    }

    showRange(1..5)
    showRange(0 until 5)
    showRange(5 downTo 1)
    showRange(0..9 step 2)
    showRange(0 until 10 step 3)
    showRange(9 downTo 2 step 3)
}

fun forWithCharRange() {
    for (c in 'a'..'z') {
        print(c)
    }
}

fun indexIntoString() {
    val s = "abc"
    for (i in 0..s.lastIndex)  {
        print(s[i] + 1)
    }
}

fun addingToChar() {
    val c = 'a'
    println(c + 25)
    println(c < 'z')
}

fun iterateOverString() {
    val s = "Jnskm "
    for (c in s) {
        print(c + 1)
    }
}

fun runHasChar() {
    fun hasChard(s: String, ch: Char): Boolean {
        for (c in s) {
            if (c == ch) return true
        }
        return false
    }

    println(hasChard("abc", 'a'))
    println(hasChard("abc", 'd'))
}

fun repeatHi() {
    repeat(2) {
        println("Hi!")
    }
}