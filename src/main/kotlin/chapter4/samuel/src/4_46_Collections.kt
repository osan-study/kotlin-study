data class Product(
    val description: String,
    val price: Double
)

fun main() {
    val list1 = List(10) { it }
    println("list1.toString() == \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\": ${list1.toString() == "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"}")

    val list2 = List(10) { 0 }
    println("list2.toString() == \"[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\": ${list2.toString() == "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]"}")

    val list3 = List(10) { 'a' + it }
    println("list3.toString() == \"[a, b, c, d, e, f, g, h, i, j]\": ${list3.toString() == "[a, b, c, d, e, f, g, h, i, j]"}")

    val list4 = List(10) { list3[it % 3] }
    println("list3.toString() == \"[a, b, c, a, b, c, a, b, c, a]\": ${list4.toString() == "[a, b, c, a, b, c, a, b, c, a]"}")

    val mutableList1 = MutableList(5, { 10 * (it + 1) })
    val mutableList2 = MutableList(5) { 10 * (it + 1) }

    println("mutableList1 == mutableList2: ${mutableList1 == mutableList2}")

    val list = listOf(-3, -1, 5, 7, 10)

    println("list.filter { it > 0 } == listOf(5, 7, 10): ${list.filter { it > 0 } == listOf(5, 7, 10)}")
    println("list.count { it > 0 } == 3: ${list.count { it > 0 } == 3}")
    println("list.find { it > 0 } == 5: ${list.find { it > 0 } == 5}")
    println("list.firstOrNull { it > 0 } == 5: ${list.firstOrNull { it > 0 } == 5}")
    println("list.lastOrNull { it < 0 } == -1: ${list.lastOrNull { it < 0 } == -1}")
    println("list.any { it > 0 } == true: ${list.any { it > 0 }}")
    println("list.any { it != 0 } == true: ${list.any { it != 0 } }")
    println("list.all { it > 0 } == false: ${!list.all { it > 0 }}")
    println("list.all { it != 0 } == true: ${list.all { it != 0 } }")
    println("list.none { it > 0 } == false: ${!list.none { it > 0 }}")
    println("list.none { it != 0 } == true: ${list.none { it != 0 } }")

    val isPositive = { i: Int -> i > 0 }
    val (pos, neg) = list.partition(isPositive)
    println("list.filter(isPositive).toString() == \"[5, 7, 10]\": ${list.filter(isPositive).toString() == "[5, 7, 10]"}")
    println("list.filterNot(isPositive).toString() == \"[-3, -1]\": ${list.filterNot(isPositive).toString() == "[-3, -1]"}")
    println("pos.toString() == \"[5, 7, 10]\": ${pos.toString() == "[5, 7, 10]"}")
    println("neg.toString() == \"[-3, -1]\": ${neg.toString() == "[-3, -1]"}")

    val nullList = listOf(1, 2, null)
    println("nullList.filterNotNull().toString() = \"[1, 2]\": ${nullList.filterNotNull().toString() == "[1, 2]"}")

    val products = listOf(
        Product("bread", 2.0),
        Product("wine", 5.0)
    )

    println("products.sumOf { it.price } == 7.0: ${products.sumOf { it.price } == 7.0}")
    println("products.sortedByDescending { it.price }.toString() == \"[Product(description=wine, price =5.0), Product(description=bread, price =2.0)]\": ${products.sortedByDescending { it.price }.toString() == "[Product(description=wine, price=5.0), Product(description=bread, price=2.0)]"}")
    println("products.minByOrNull { it.price } == \"Product(description=bread, price =2.0)\": ${products.minByOrNull { it.price } == Product(description="bread", price =2.0)}")

    val listAlpha = listOf('a', 'b', 'c', 'X', 'Z')
    println("listAlpha.takeLast(3) == listOf('c', 'X', 'Z'): ${listAlpha.takeLast(3) == listOf('c', 'X', 'Z')}")
    println("listAlpha.takeLastWhile { it.isUpperCase() } == listOf('X', 'Z'): ${listAlpha.takeLastWhile { it.isUpperCase() } == listOf('X', 'Z')}")

    println("listAlpha.drop(1) == listOf('b', 'c', 'X', 'Z'): ${listAlpha.drop(1) == listOf('b', 'c', 'X', 'Z')}")
    println("listAlpha.dropWhile { it.isLowerCase() } == listOf('X', 'Z'): ${listAlpha.dropWhile { it.isLowerCase() } == listOf('X', 'Z')}")

    val set = setOf("a", "ab", "ac")
    println("set.maxByOrNull { it.length }?.length == 2: ${set.maxByOrNull { it.length }?.length == 2}")
    println("set.filter { it.contains('b') } == listOf(\"ab\"): ${set.filter { it.contains('b') } == listOf("ab")}")
    println("set.map { it.length } == listOf(1, 2, 2): ${set.map { it.length } == listOf(1, 2, 2)}")
}