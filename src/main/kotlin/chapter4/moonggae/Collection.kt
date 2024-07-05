package chapter4.moonggae

import chapter1.moonggae.util.runExample
import chapter3.moonggae.toPrettyString

fun main() {
    runExample(::initList)
    runExample(::initMutableList)
    runExample(::collectionFunctions)
    runExample(::collectionOperation)
    runExample(::takeOrDrop)
    runExample(::setOperations)
}

/*
- List 함수 원형
public inline fun <T> List(size: Int, init: (index: Int) -> T): List<T> = MutableList(size, init)
*/
fun initList() {
    val list1 = List(size = 10) { it }
    println(list1)

    val list2 = List(size = 10) { 0 }
    println(list2)

    val list3 = List(size = 10) { 'a' + it }
    println(list3)

    val list4 = List(10) { list3[it % 3] }
    println(list4)
}


/*
- MutableList 함수 원형
public inline fun <T> MutableList(size: Int, init: (index: Int) -> T): MutableList<T> {
    val list = ArrayList<T>(size)
    repeat(size) { index -> list.add(init(index)) }
    return list
}
 */
fun initMutableList() {
    val mutableList1 = MutableList(5, { 10 * (it + 1) })
    println(mutableList1)
    val mutableList2 = MutableList(5) { 10 * (it + 1) }
    println(mutableList2)
}

fun collectionFunctions() {
    val list: List<Int> = listOf(-3, -1, 5, 7, 10)
    println("list: $list")

    println("list.filter { it > 0 }: ${list.filter { it > 0 }}")
    println("list.count{ it > 0 }: ${list.count{ it > 0 }}")

    println("list.find { it > 0 }: ${list.find { it > 0 }}")
    println("list.firstOrNull { it > 100 }: ${list.firstOrNull { it > 100 }}")
    println("list.lastOrNull { it < 0 }: ${list.lastOrNull { it < 0 }}")

    println("list.any { it > 0 }: ${list.any { it > 0 }}")
    println("list.any { it != 0 }: ${list.any { it != 0 }}")

    println("list.all { it > 0 }: ${list.all { it > 0 }}")
    println("list.all { it != 0 }: ${list.all { it != 0 }}")

    println("list.none { it > 0 }: ${list.none { it > 0 }}")
    println("list.none { it == 0 }: ${list.none { it == 0 }}")

    val isPositive = { i: Int -> i > 0 }
    println()

    println("list.filter(isPositive): ${list.filter(isPositive)}")
    println("list.filterNot(isPositive): ${list.filterNot(isPositive)}")
    println("list.partition(isPositive): ${list.partition(isPositive)}")

    val nullContainingList = listOf(1, 2, null)
    println()

    println("nullContainingList: $nullContainingList")
    println("nullContainingList.filterNotNull(): ${nullContainingList.filterNotNull()}")
}

fun collectionOperation() {
    // sumBy, sumByDouble is deprecated
    println("chickenList.sumOf { it.price }: ${chickenList.sumOf { it.price }}")
    println("chickenList.sortedByDescending { it.price }:")
    println(chickenList.sortedByDescending { it.price }.toPrettyString())
}

fun takeOrDrop() {
    val list = listOf('a', 'b', 'c', 'X', 'Z')
    println("list: $list")

    println("list.takeLast(3): ${list.takeLast(3)}")
    println("list.takeLastWhile { it.isUpperCase() }: ${list.takeLastWhile { it.isUpperCase() }}")
    println("list.drop(1): ${list.drop(1)}")
    println("list.dropWhile { it.isLowerCase() }: ${list.dropWhile { it.isLowerCase() }}")
}

fun setOperations() {
    val set = setOf("a", "ab", "ac")
    println("set: $set")
    println("set.maxByOrNull { it.length }?.length: ${set.maxByOrNull { it.length }?.length}")
    println("set.filter { it.contains('b') }: ${set.filter { it.contains('b') }}")
    println("set.map { it.length }: ${set.map { it.length }}")
}