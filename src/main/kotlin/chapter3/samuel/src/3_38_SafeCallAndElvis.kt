fun String.echo() {
    println(this.uppercase())
    println(this)
    println(this.lowercase())
}

fun main() {

    val s1: String? = "Samu!"
    println("s1?.echo(): ${s1?.echo()}")
    val s2: String? = null
    println("s2?.echo(): ${s2?.echo()}")

    val s3: String? = "abc"
    println("(s3 ?: \"---\") == \"abc\": ${(s3 ?: "---") == "abc"}")
    val s4: String? = null
    println("(s4 ?: \"---\") == \"---\": ${(s4 ?: "---") == "---"}")

}