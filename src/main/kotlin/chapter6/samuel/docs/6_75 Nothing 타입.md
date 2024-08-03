# 6_75 Nothing 타입
# Nothing 타입
<b>Nothing</b> 은 함수가 결코 반환되지 않는다는 사실을 표현한 반환 타입  
예외처리랑 같아 보이지만, 큰 차이점은 Exception 의 복구 기능을 수행하지 않음  
따라서 Nothing 으로 처리될 경우 <b>뒤에 있는 코드들은 실행되지 않음</b>

```kotlin
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
== result
java.lang.Exception: fail(1)
    at _6_75_NothingKt.fail(6_75_Nothing.kt:17)
    at _6_75_NothingKt.main(6_75_Nothing.kt:59)
    at _6_75_NothingKt.main(6_75_Nothing.kt)
java.lang.Exception: fail(2)
    at _6_75_NothingKt.fail(6_75_Nothing.kt:17)
    at _6_75_NothingKt.main(6_75_Nothing.kt:65)
    at _6_75_NothingKt.main(6_75_Nothing.kt)
nullableString == null: true
nullableInt == null: true
ints == listNone: true
```