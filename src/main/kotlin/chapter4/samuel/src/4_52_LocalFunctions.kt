fun main() {
    val logMsg = StringBuilder()
    fun log(message: String) = logMsg.appendLine(message)
    log("starting computation")
    val x = 42
    log("Computation result: $x")

    println("logMsg.toString() = \n${logMsg.toString()}")

    val list = listOf("Sam", "Bob", "Jane")

    fun interesting(str: String): (Boolean) {
        return str.contains("Sam")
    }

    println("list.any(::interesting) == list.any(fun(str: String): Boolean = str.contains(\"Sam\")): ${list.any(::interesting) == list.any(fun(str: String): Boolean = str.contains("Sam"))}")

    val listNum = listOf(1, 2, 3, 4, 5)
    val value = 3
    var result = ""
    listNum.forEach sam@ {
        result += it
        if(it == value) {
            return@sam
        }
    }
    println("result=$result")

    fun doubleBracket(): (Int) -> Int {
        val func = fun(i: Int) = i + 1
        return func
    }

    println("doubleBracket()(3): ${doubleBracket()(3)}")

}