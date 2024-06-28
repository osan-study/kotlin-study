fun isNullOrEmpty(str: String?): Boolean {
    return str == null || str.isEmpty()
}

fun main() {
    var s1: String? = null
    val s2 = ""

    println("s1.isNullOrEmpty() == true: ${s1.isNullOrEmpty() == true}")
    println("s1.isNullOrBlank() == true: ${s1.isNullOrBlank() == true}")
    println("s2.isNullOrBlank() == true: ${s2.isNullOrBlank() == true}")

    println("isNullOrEmpty(null): ${isNullOrEmpty(null)}")
    println("isNullOrEmpty(\"\"): ${isNullOrEmpty("")}")
}