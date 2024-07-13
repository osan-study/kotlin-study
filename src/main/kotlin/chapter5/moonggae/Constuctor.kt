package chapter5.moonggae

data class Color(
    val alpha: Int,
    val red: Int,
    val green: Int,
    val blue: Int
) {
    constructor(
        red: Int,
        green: Int,
        blue: Int
    ): this(0xFF, red, green, blue)

    constructor(value: Int) : this(
        (value shr 24) and 0xFF,
        (value shr 16) and 0xFF,
        (value shr 8) and 0xFF,
        value and 0xFF
    )

    constructor(value: String) : this(
        parseColor(value).first,
        parseColor(value).second,
        parseColor(value).third,
        parseColor(value).fourth
    )

    init {
        println("Call init")
    }

    companion object {
        @OptIn(ExperimentalStdlibApi::class)
        private fun parseColor(value: String): Quadruple<Int, Int, Int, Int> {
            val colorValue = if (value.startsWith("#")) value.substring(1) else value
            return when (colorValue.length) {
                6 -> {
                    val red = colorValue.substring(0, 2).hexToInt(HexFormat.Default)
                    val green = colorValue.substring(2, 4).hexToInt(HexFormat.Default)
                    val blue = colorValue.substring(4, 6).hexToInt(HexFormat.Default)
                    Quadruple(0xFF, red, green, blue)
                }
                8 -> {
                    val alpha = colorValue.substring(0, 2).hexToInt(HexFormat.Default)
                    val red = colorValue.substring(2, 4).hexToInt(HexFormat.Default)
                    val green = colorValue.substring(4, 6).hexToInt(HexFormat.Default)
                    val blue = colorValue.substring(6, 8).hexToInt(HexFormat.Default)
                    Quadruple(alpha, red, green, blue)
                }
                else -> throw IllegalArgumentException("Invalid color length")
            }
        }
    }

    data class Quadruple<out A, out B, out C, out D>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D
    )
}

fun main() {
    val red = Color(255, 255, 0, 0)
    println("red: $red")

    val green = Color(0, 0xFF, 0)
    println("green: $green")

    val blue = Color("#0000FF")
    println("blue: $blue")

    val transparent = Color(0x000000)
    println("transparent: $transparent")
}