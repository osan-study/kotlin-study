data class Simple(
    val arg1: String,
    var arg2: Int
)

data class DetailedContainer(
    val name: String,
    val surname: String,
    val number: String,
    val address: String
)

fun main() {
    val s1 = Simple("Hi", 31)
    val s2 = Simple("Hi", 31)
    println("s1.toString(): ${s1.toString()}")
    println("s1.toString() == \"Simple(arg1=Hi,  arg2=31)\": ${s1.toString() == "Simple(arg1=Hi, arg2=31)"}")
    println("s1 == s2: ${s1 == s2}")
    s1.arg2 = 10
    println("s1.arg2 = 10")
    println("s1 == s2: ${s1 == s2}")

    val con1 = DetailedContainer("Sam", "SAMUSAMU", "10", "20")
    val con2 = con1.copy(number = "20", address = "30")

    println("con1.toString(): $con1")
    println("con2.toString(): $con2")
}