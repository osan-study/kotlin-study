import atomictest.eq

fun main() {

    try {
        println("1$".toIntOrNull() eq null)
        var i = "1$".toInt()
    } catch (e: NumberFormatException) {
        println("in catch e: NumberFormatException")
        e.printStackTrace()
    }

    try {
        5000 / 0
    } catch (e: ArithmeticException) {
        println("in catch e: ArithmeticException")
        e.printStackTrace()
    }

    try {
        throw NullPointerException()
    } catch (e: NullPointerException) {
        println("in catch e: NullPointerException")
        e.printStackTrace()
    }

}