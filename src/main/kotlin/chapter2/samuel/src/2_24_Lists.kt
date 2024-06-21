import atomictest.eq

fun main() {
    val ints = listOf(99, 3, 5, 7, 11, 13)
    ints eq  "[99, 3, 5, 7, 11, 13]"

    var result = ""
    for (i in ints) {
        result += "$i "
    }
    result eq "99 3 5 7 11 13"

    ints[4] eq 11

    try {
        ints[ints.size]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("in catch e: ArrayIndexOutOfBoundsException")
        e.printStackTrace()
    }

    val strs = listOf("B", "D", "A", "C")
    println("strs: $strs")
    // strs 변수의 정렬을 해주는 것이 아닌 정렬된 새로운 리스트를 리턴하는 함수임
    println("strs.sorted(): ${strs.sorted()}")
    println("strs.reversed(): ${strs.reversed()}")
    println("strs.first(): ${strs.first()}")
    println("strs.last(): ${strs.last()}")
    println("strs.takeLast(3): ${strs.takeLast(3)}")

    var strs2: MutableList<String> = mutableListOf("B", "D", "A", "C")
    println("strs2: $strs2")
    strs2.add("E")
    strs2.add("F")
    println("strs2.add(\"E\")")
    println("strs2: $strs2")
    println("strs2.add(\"F\")")
    println("strs2: $strs2")
}