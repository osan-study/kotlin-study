package chapter4.moonggae

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::eagerVsLazyEvaluation)
    runExample(::generateSequence1)
    runExample(::generateSequence2)
    runExample(::numberSequence)
}

fun eagerVsLazyEvaluation() {
    fun Int.isEven(): Boolean {
        println("$this.isEven()")
        return this % 2 == 0
    }

    fun Int.square(): Int {
        println("$this.square()")
        return this * this
    }

    fun Int.lessThanTen(): Boolean {
        println("$this.lessThanTen()")
        return this < 10
    }

    val list = listOf(1, 2, 3, 4)
    println("list >>")
    list
        .filter(Int::isEven)
        .map(Int::square)
        .any(Int::lessThanTen)

    println("asSequence >>")
    list.asSequence()
        .filter(Int::isEven)
        .map(Int::square)
        .any(Int::lessThanTen)
}

fun generateSequence1() {
    val naturalNumbers = generateSequence(1) { it + 1 }
    println("naturalNumbers.take(3).toList(): ${naturalNumbers.take(3).toList()}")
    println("naturalNumbers.take(10).sum(): ${naturalNumbers.take(10).sum()}")
}

fun generateSequence2() {
    var items = mutableListOf(
        "first", "second", "third", "XXX", "4th"
    )
    val seq = generateSequence {
        val tem = items
        tem.removeAt(0).takeIf { it != "XXX" } // null 반환시 종료
    }


    println("seq.toList(): ${seq.toList()}")
//    items = mutableListOf(
//        "first", "second", "third", "XXX", "4th"
//    )
//    println(items)
    println("seq.toList(): ${seq.toList()}")
}

fun numberSequence() {
    val seq = generateSequence(6) { current ->
        (current - 1).takeIf { it > 0 }
    }

    println(seq.toList())
    println(seq.toList())
}