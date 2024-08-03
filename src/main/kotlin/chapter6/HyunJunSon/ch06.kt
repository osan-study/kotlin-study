package chapter6.HyunJunSon


//
//class Exception1(
//    val value: Int
//) : Exception("wrong value: $value")
//
//
//fun function1() : Int = throw Exception1(-52)
//fun function2() = function1()
//fun function3() = function2()
//
//fun main() {
//    function3()
//}

//class Roots(
//    val root1: Double,
//    val root2: Double
//)
//
//fun quadraticZeroes(
//    a: Double,
//    b: Double,
//    c: Double
//) : Roots {
//    require(a != 0.0) {"a iz zero"}
//    val underRadical = b * b - 4 * a *  c
//    require(underRadical >= 0) {
//        "Negtive underRadical: $underRadical"
//    }
//    val squareRoot = sqrt(underRadical)
//    val root1 = (-b - squareRoot) / 2 * a
//    val root2 = (-b + squareRoot) / 2 * a
//    return Roots(root1, root2)
//}


//import org.slf4j.LoggerFactory
//
//fun main() {
//    // 로거 생성
//    val logger = LoggerFactory.getLogger("MyLogger")
//
//    // 로그 메시지 출력
//    logger.trace("This is a trace message.")   // TRACE 레벨 메시지
//    logger.debug("This is a debug message.")   // DEBUG 레벨 메시지
//    logger.info("This is an info message.")    // INFO 레벨 메시지
//    logger.warn("This is a warning message.")  // WARN 레벨 메시지
//    logger.error("This is an error message.")  // ERROR 레벨 메시지
//
////    2024-08-03 05:39:45 [main] DEBUG MyLogger - This is a debug message.
////    2024-08-03 05:39:45 [main] INFO MyLogger - This is an info message.
////    2024-08-03 05:39:45 [main] WARN MyLogger - This is a warning message.
////    2024-08-03 05:39:45 [main] ERROR MyLogger - This is an error message.
//}

//import org.slf4j.LoggerFactory
//
//
//fun fortyTwo() = 42
//
//fun testFortyTwo(n: Int = 42) {
//    assertEquals(
//        expected = n,
//        actual = fortyTwo(),
//        message = "Incorrect, expected $n but got ${fortyTwo()}"
//    )
//}
//
//fun allGood(b: Boolean = true) = b
//
//fun testAllGood(b: Boolean = true) {
//    assertTrue(allGood(b), "Not good")
//}
//
//fun main() {
//    // 로거 생성
//    val logger = LoggerFactory.getLogger("MyLogger")
//
//    // 로깅 메시지 출력
//    logger.debug("Starting main function...")
//
//    // 테스트 함수 호출
//    testFortyTwo()
//    testAllGood()
//
//    logger.info("Tests completed successfully.")
//}

import chapter6.HyunJunSon.State.*

enum class State { On, Off, Paused}

class StateMachine {
    var state: State = Off
        private set
    private fun transition(
        new: State, current: State= On
    ){
        if (new == Off && state != Off)
            state = Off
        else if(state == current)
            state = new
    }

    fun start() = transition(On, Off)
    fun pause() = transition(Paused, On)
    fun resume() = transition(On, Paused)
    fun finish() = transition(Off)
}