import aa.DataFile
import io.github.oshai.kotlinlogging.KLogging

private val log = KLogging().logger

val logFile = DataFile("simpleLogFile.txt").reset()

fun debug(msg: String) = System.err.println("Debug: $msg")

fun trace(msg: String) = logFile.appendText("Trace: $msg\n")

class Logger(fileName: String) {
    val logFile = DataFile(fileName).reset()
    private fun log(type: String, msg: String) = logFile.appendText("$type: $msg\n")

    fun trace(msg: String) = log("Trace", msg)
    fun debug(msg: String) = log("Debug", msg)
    fun info(msg: String) = log("Info", msg)
    fun warn(msg: String) = log("Warn", msg)
    fun error(msg: String) = log("Error", msg)

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

    val msg = "hello, Kotlin Logging!"

    log.trace(msg)
    log.debug(msg)
    log.info(msg)
    log.warn(msg)
    log.error(msg)

    debug("Simple Logging Strategy")
    trace("line 1")
    trace("line 2")
    println(logFile.readText())

    logger.report("Hello Atomic Log!")
    println(logger.logFile.readText())

}