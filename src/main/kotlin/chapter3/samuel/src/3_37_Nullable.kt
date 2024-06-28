fun main() {
    val s1 = "abc"
    val s2: String? = null
    val s3: String? = s1

    println("s1.length: ${s1.length}")
//    println(s2.length)

    if(s2 != null) {
        println("s2.length: ${s2.length}")
    }

}