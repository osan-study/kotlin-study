package chapter6.moonggae.logging

import chapter6.moonggae.check.DataFile

val logFile = DataFile("simpleLogFile.txt").reset()

fun debug(msg: String) =
    System.err.println("Debug: $msg")
// 비활성화하고 싶으면 다음과 같이 바꿔라
// fun debug(msg: String) = Unit

fun trace(msg: String) =
    logFile.appendText("Trace: $msg\n")

fun main() {
    debug("Simple Logging Strategy")
    trace("Line 1")
    trace("Line 2")
    println(logFile.readText())
}
/* Sample Output:
Debug: Simple Logging Strategy
Trace: Line 1
Trace: Line 2
*/