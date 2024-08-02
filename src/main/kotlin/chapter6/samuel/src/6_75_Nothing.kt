import kotlin.random.Random

fun infinite(): Nothing {
    while (true) {}
}

//fun foo(): Nothing {
//    while(true) {
//        if(Random.nextBoolean()) break
//    }
//}

fun later(s: String): String = TODO("later()")

fun later2(s: String): Int = TODO()

fun fail(i: Int): Nothing = throw Exception("fail($i)")

class BadData(m: String) : Exception(m)

fun checkObject(obj: Any?): String =
    if (obj is String) obj else throw BadData("Needs String, got $obj")


fun test(checkObj: (obj: Any?) -> String) {
    checkObj("abc")
    try {
        checkObj(null)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        checkObj(123)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun failWithBadData(obj: Any?): Nothing = throw BadData("Needs String, got $obj")

fun checkObject2(obj: Any?): String = (obj as? String) ?: failWithBadData(obj)

fun main() {

//    try {
//        later("Hello")
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//
//    try {
//        later2("Hello!")
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }

    try {
        fail(1)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        fail(2)
    } catch (e: Exception) {
        e.printStackTrace()
    }

//    test(::checkObject)
//    test(::checkObject2)

    val none: Nothing? = null

    var nullableString: String? = null
    nullableString = "abc"
    nullableString = none
    println("nullableString == null: ${nullableString == null}")

    val nullableInt: Int? = none
    println("nullableInt == null: ${nullableInt == null}")

    val listNone: List<Nothing?> = listOf(null)
    val ints: List<Int?> = listOf(null)
    println("ints == listNone: ${ints == listNone}")

}