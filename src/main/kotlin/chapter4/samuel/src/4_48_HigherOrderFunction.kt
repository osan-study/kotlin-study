
val isPlus: (Int) -> Boolean = { it > 0 }

val helloWorld: () -> String = { "Hello, world!" }

val sum: (Int, Int) -> Int = { x, y -> x + y }

fun <T> List<T>.any2(
    predicate: (T) -> Boolean
): Boolean {
    for (item in this) {
        if (predicate(item)) {
            return true
        }
    }
    return false
}

fun repeat2(
    times: Int,
    action: (Int) -> Unit
) {
    for (i in 0 until times) {
        action(i)
    }
}

fun main() {

    println("listOf(1, 2, -3).any(isPlus) == true: ${listOf(1, 2, -3).any(isPlus)}")
    println("helloWorld() == \"Hello, world!\": ${helloWorld() == "Hello, world!"}")
    println("sum(1, 2) == 3: ${sum(1, 2) == 3}")

    val ints = listOf(1, 2, -3)
    println("ints.any2 { it > 0 } == true: ${ints.any2 { it > 0 }}")
    val strings = listOf("one", " ")
    println("strings.any2 { it.isBlank() } == true: ${strings.any2 { it.isBlank() }}")
    println("strings.any2(String::isNotBlank) == true: ${strings.any2(String::isNotBlank)}")

    repeat2(3) { println("#$it")}

    val transform: (String) -> Int? = { s: String -> s.toIntOrNull() }
    println("transform(\"123\") == 123: ${transform("123") == 123}")
    println("transform(\"abc\") == null: ${transform("abc") == null}")

    val x = listOf("112", "abc")
    println("x.mapNotNull(transform).toString() == \"[112]\": ${x.mapNotNull(transform).toString() == "[112]"}")
    println("x.mapNotNull { it.toIntOrNull() }.toString() == \"[112]\": ${x.mapNotNull { it.toIntOrNull() }.toString() == "[112]"}")

    val returnTypeNullable: (String) -> Int? = { null }
    val mightBeNull: ((String) -> Int)? = null

    println("returnTypeNullable(\"abc\") == null: ${returnTypeNullable("abc") == null}")
    println("mightBeNull?.invoke(\"abc\") == null: ${mightBeNull?.invoke("abc") == null}")

}
