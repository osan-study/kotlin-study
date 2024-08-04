package chapter6.moonggae.nothing

fun failWithBadData(obj: Any?): Nothing =
    throw BadData("Needs String, got $obj")

fun checkObject2(obj: Any?): String =
    (obj as? String) ?: failWithBadData(obj)

fun main() {
    test(::checkObject2)
}