package chapter4.HyunJunSon

//fun main() {
//    val numbersSequence = sequenceOf("four", "three", "two", "one") // inlined$Sequence$1@1fb3ebeb
////    println(numbersSequence)
//    val numbers = listOf("one", "two", "three", "four")
//    val numbersSequence2 = numbers.asSequence()  //$inlined$Sequence$1@15aeb7ab 이터러블.asSequence()
//
//    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element //[1, 3, 5, 7, 9]
////    println(oddNumbers.take(5).toList())
//}

//fun main() {
//    val oddNumbers = sequence {
//        yield(1)
//        yieldAll(listOf(3, 5))
//        yieldAll(generateSequence(7) { it + 2 })
//    }
//    println(oddNumbers.take(5).toList())
//}

fun main() {
    val array = arrayOf(1, 2, 3)

// create a sequence with a function, returning an iterator
//    val sequence1 = Sequence { array.iterator() }
//    println(sequence1.joinToString()) // 1, 2, 3
//    println(sequence1.drop(1).joinToString()) // 2, 3

//// create a sequence from an existing iterator
//// can be iterated only once
    val sequence2 = array.iterator().asSequence()
    println(sequence2.joinToString()) // 1, 2, 3
// sequence2.drop(1).joinToString() // <- iterating sequence second time will fail


}