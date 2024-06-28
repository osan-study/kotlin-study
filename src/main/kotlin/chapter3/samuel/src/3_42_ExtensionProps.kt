
val String.indices: IntRange
    get() = 0 until length

fun main() {
    println("\"abc\".indices == 0..2: ${"abc".indices == 0..2}")
}

fun checkStringList(data: Any) {
    // 에러!! Cannot check for instance of erased type: List<String>
//    if (data is List<String>) {
//    }
}

fun checkList(data: Any) {
    if (data is List<*>) {  // '*'을 활용하여 확인
        val element: Any? = data[0]
    }
}