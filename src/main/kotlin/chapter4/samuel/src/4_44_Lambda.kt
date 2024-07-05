fun main() {
    val list = listOf(1, 2, 3, 4)
    val result = list.map({n: Int -> "[$n]"})
    val result2 = list.map({n -> "[$n]"})
    val result3 = list.map({"[$it]"})

    val list2 = listOf('a', 'b', 'c', 'd')
    val result4 =  list2.map{"[${it.uppercase()}]"}

    println("val result = list.map({n: Int -> \"[\$n]\"})")
    println("val result2 = list.map({n -> \"[\$n]\"})")
    println("val result3 = list.map({\"[\$it]\"})")

    println("result == listOf(\"[1]\", \"[2]\", \"[3]\", \"[4]\"): ${result == listOf("[1]", "[2]", "[3]", "[4]")}")
    println("result2 == listOf(\"[1]\", \"[2]\", \"[3]\", \"[4]\"): ${result2 == listOf("[1]", "[2]", "[3]", "[4]")}")
    println("result3 == listOf(\"[1]\", \"[2]\", \"[3]\", \"[4]\"): ${result3 == listOf("[1]", "[2]", "[3]", "[4]")}")


    println("val list2 = listOf('a', 'b', 'c', 'd')")
    println("val result4 =  list2.map{\"[\${it.uppercase()}]\"}")
    println("result4 == listOf(\"[A]\", \"[B]\", \"[C]\", \"[D]\"): ${result4 == listOf("[A]", "[B]", "[C]", "[D]")}")

    val list3 = listOf(9, 11, 23, 32)
    list3.joinToString(" ") {"[$it]"}
    println("val list3 = listOf(9, 11, 23, 32)")
    println("list3.joinToString(\" \") {\"[\$it]\"}")
    println("list3.joinToString(\" \") {\"[\$it]\"} == \"[9] [11] [23] [32]\": ${list3.joinToString(" ") {"[$it]"} == "[9] [11] [23] [32]"}")
}