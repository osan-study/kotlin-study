fun main() {

    var x: String? = "abc"
    println("x!! == \"abc\": ${x!! == "abc"}")

    x = null
    try {
        val s: String = x!!
    } catch (e: Exception) {
        println("Exception: ${e}")
    }

    val s: String? = "abc"
    println("s!!.length == 3: ${s!!.length == 3}")
}