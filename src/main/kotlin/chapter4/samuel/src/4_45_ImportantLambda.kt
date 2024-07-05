fun fileterEven(nums: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (num in nums) {
        if(num % 2 == 0){
            result.add(num)
        }
    }
    return result
}

fun greaterThan2(nums: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (num in nums) {
        if(num > 2){
            result.add(num)
        }
    }
    return result
}

fun main() {
    println("fileterEven(listOf(1, 2, 3, 4)) == listOf(2, 4): ${fileterEven(listOf(1, 2, 3, 4)) == listOf(2, 4)}")
    println("greaterThan2(listOf(1, 2, 3, 4)) == listOf(3, 4): ${greaterThan2(listOf(1, 2, 3, 4)) == listOf(3, 4)}")

    val list = listOf(1, 2, 3, 4)
    val even = list.filter { it % 2 == 0 }
    val greater2Than2 = list.filter { it > 2 }
    val isEven = { e: Int -> e % 2 == 0 }

    println("even == listOf(2, 4): ${even == listOf(2, 4)}")
    println("greater2Than2 == listOf(3, 4): ${greater2Than2 == listOf(3, 4)}")
    println("list.filter(isEven) == listOf(2, 4): ${list.filter(isEven)}")
    println("list.any(isEven) == ${list.any(isEven)}")

    val list2 = listOf(1, 5, 7, 10)
    var sum = 0
    val divider = 5
    list2.filter { it % divider == 0 } .forEach { sum += it }

    println("list2.filter { it % divider == 0 } .forEach { sum += it }")
    println("sum == 15: ${ sum == 15 }")

}
