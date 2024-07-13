fun main() {
    val list = listOf(1, 2, 3, 4)
    println("list.filter { it % 2 == 0 } .map { it * it } .any { it < 10 } == true: ${list.filter { it % 2 == 0 } .map { it * it } .any { it < 10 }}")

    val mid1 = list.filter { it % 2 == 0 }
    println("list.filter { it % 2 == 0 }: $mid1")
    val mid2 = mid1.map { it * it }
    println("mid1.map { it * it }: $mid2")
    val mid3 = mid2.any { it < 10 }
    println("mid2.any { it < 10 }: $mid3")

    println("list.asSequence().filter { it % 2 == 0 } .map { it * it } .any { it < 10 }} == true: ${list.asSequence().filter { it % 2 == 0 } .map { it * it } .any { it < 10 }}}")

}