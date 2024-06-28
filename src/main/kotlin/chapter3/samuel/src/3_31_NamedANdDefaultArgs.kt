fun color(red: Int, green: Int, blue: Int) = "($red, $green, $blue)"

fun color2(red: Int = 0, green: Int = 0, blue: Int = 0) = "($red, $green, $blue)"

class Color3(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0
) {
    override fun toString() = "($red, $green, $blue)"
}

class DefaultArg

val da = DefaultArg()

fun g(d: DefaultArg = da) = println(d)

fun h(d: DefaultArg = DefaultArg()) = println(d)

fun main() {
    println("color(1, 2, 3) == \"(1, 2, 3)\": ${color(1, 2, 3) == "(1, 2, 3)"}")
    println(
        """
            color(
                red = 76,
                green = 89,
                blue = 0
            ) == "(76, 89, 0)": 
            ${color(
                red = 76,
                green = 89,
                blue = 0
            ) == "(76, 89, 0)"}
        """.trimIndent()
    )
    println("color(52, 34, blue = 0) == \"(52, 34, 0)\": ${color(52, 34, blue = 0) == "(52, 34, 0)"}")
    println("color(blue = 0, red = 99, green = 52) == \"(99, 52, 0)\": ${color(blue = 0, red = 99, green = 52) == "(99, 52, 0)"}")
    println("color(red = 255, 255, 0) == \"(255, 255, 0)\": ${color(red = 255, 255, 0) == "(255, 255, 0)"}")

    println("color2(139) == \"(139, 0, 0)\": ${color2(139) == "(139, 0, 0)"}")
    println("color2(blue = 139) == \"(0, 0, 139)\": ${color2(blue =139) == "(0, 0, 139)"}")
    println("color2(255, 165) == \"(255, 165, 0)\": ${color2(255, 165) == "(255, 165, 0)"}")
    println("color2(red = 128, blue = 128) == \"(128, 0, 128)\": ${color2(red = 128, blue = 128) == "(128, 0, 128)"}")

    println("Color3(red = 77).toString() == \"(77, 0, 0)\" : ${Color3(red = 77).toString() == "(77, 0, 0)"}")

    val list = listOf(1, 2, 3)
    println("list.toString() == \"[1, 2, 3]\": ${list.toString() == "[1, 2, 3]"}")
    println("list.joinToString(prefix = \"(\", postfix = \")\") == \"(1, 2, 3)\": ${list.joinToString(prefix = "(", postfix = ")") == "(1, 2, 3)"}")
    println("list.joinToString(separator = \":\") == \"1:2:3\": ${list.joinToString(separator = ":") == "1:2:3"}")

    g()
    g()
    h()
    h()

    println("list.joinToString(\". \", \"\", \"!\") == \"1. 2. 3!\": ${list.joinToString(". ", "", "!") == "1. 2. 3!"}")
    println("list.joinToString(separator = \". \", postfix = \"!\") == \"1. 2. 3!\": ${list.joinToString(separator = ". ", postfix = "!") == "1. 2. 3!"}")
}