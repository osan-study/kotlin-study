package chapter5.moonggae

interface Logger {
    fun log(message: String)
}

class DefaultLogger(val tag: String): Logger {
    override fun log(message: String) {
        println("$tag| $message")
    }
}

interface Activity {
    fun onCreate()
    fun onStart()
    fun onResume()
}

class MainActivity(
    private val logger: DefaultLogger
): Activity, Logger by logger {
    init {
        onCreate()
        onStart()
        onResume()
    }

    override fun onCreate() {
        log("onCreate")
    }

    override fun onStart() {
        log("onStart")
    }

    override fun onResume() {
        log("onResume")
    }
}


fun main() {
    val mainActivity = MainActivity(DefaultLogger("MainActivity"))
    val mainActivityLogger: Logger = mainActivity
    mainActivityLogger.log("finished init")
}