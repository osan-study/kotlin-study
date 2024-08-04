package chapter6.moonggae.logging

import atomictest.eq
import chapter6.moonggae.check.DataFile

class Logger(fileName: String) {
    val logFile = DataFile(fileName).reset()
    private fun log(type: String, msg: String) =
        logFile.appendText("$type: $msg\n")
    fun trace(msg: String) = log("Trace", msg)
    fun debug(msg: String) = log("Debug", msg)
    fun info(msg: String) = log("Info", msg)
    fun warn(msg: String) = log("Warn", msg)
    fun error(msg: String) = log("Error", msg)
    // 기본 테스트를 위한 함수다
    fun report(msg: String) {
        trace(msg)
        debug(msg)
        info(msg)
        warn(msg)
        error(msg)
    }
}

private val logger = Logger("AtomicLog.txt")

fun main() {
    logger.report("Hello, Atomic Log!")
    logger.logFile.readText() eq """
  Trace: Hello, Atomic Log!
  Debug: Hello, Atomic Log!
  Info: Hello, Atomic Log!
  Warn: Hello, Atomic Log!
  Error: Hello, Atomic Log!
  """
}