package chapter5.HyunJunSon

//class MyClass {
//    // 첫 번째 init 블록
//    init {        println("첫 번째 init 블록 실행")
//    }
//    // 변수 선언 및 초기화
//    val number = 10
//    // 두 번째 init 블록
//    init {
//        println("두 번째 init 블록 실행")
//        println("number의 값은: $number")
//    }
//    // 메소드 정의
//    fun display() {        println("display 메소드 호출")
//    }
//    // 세 번째 init 블록
//    init {        println("세 번째 init 블록 실행")
//    }}
//
//fun main() {
//    val myObject = MyClass()
//    myObject.display()}


open class Transport
data class Train(
    val line: String) : Transport()

data class Bus(
    val number: String,  val capacity: Int) : Transport()

fun travel(transport : Transport) =
    when(transport) {
        is Train -> "Train ${transport.line}"
        is Bus -> "Bus ${transport.number}: "+ "size ${transport.capacity}"       else -> "$transport is in limbo!"    }

fun main() {
    val map = listOf(Train("S1"), Bus("11", 90)).map(::travel)
    println(map)
}