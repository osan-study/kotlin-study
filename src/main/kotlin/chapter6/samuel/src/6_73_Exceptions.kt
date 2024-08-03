class Exception1(val value: Int) : Exception("wrong value: $value")

open class Exception2(description: String) : Exception(description)

class Exception3(
    description: String
) : Exception2(description)


fun function1(): Int = throw Exception1(-52)

fun function2() = function1()

fun function3() = function2()

fun toss(which: Int) = when (which) {
    1 -> Exception1(1)
    2 -> Exception2("Exception 2")
    3 -> Exception3("Exception 3")
    else -> "OK"
}

fun test(which: Int): Any? =
    try {
        toss(which)
    } catch (e: Exception1) {
        e.value
    } catch (e: Exception3) {
        e.message
    } catch (e: Exception2) {
        e.message
    }

fun testCatchOrder(which: Int) =
    try {
        toss(which)
    } catch (e: Exception2) {
        "Handler for Exception2 got ${e.message}"
    } catch (e: Exception3) {
        "Handler for Exception3 got ${e.message}"
    }

fun testCode(code: Int) {
    if (code <= 1000) {
       throw IllegalArgumentException(
           "'code' must be > 1000: $code"
       )
    }
}

class IncorrectInputException(message: String) : Exception(message)

fun checkCode(code: Int) {
    if (code <= 1000) {
        throw IncorrectInputException(
            "Code must be > 1000: $code"
        )
    }
}

fun checkValue(value: Int) {
    try {
        println(value)
        if (value <= 0) {
            throw IllegalArgumentException(
                "value must be positive: $value"
            )
        }
    } finally {
        println("in finally clause for $value")
    }
}

data class Switch(
    var on: Boolean = false,
    var result: String = "OK"
)

fun testFinally(i: Int): Switch {
    val sw = Switch()
    try {
        when (i) {
            0 -> throw IllegalArgumentException()
            1 -> return sw
        }
    } catch (e: IllegalArgumentException) {
        sw.result = "exception"
    } finally {
        sw.on = false
    }
    return sw
}

fun main() {
    try {
        println(Exception1(13))
        println(Exception3("error"))
    } catch (e: Exception) {
        println(e.message)
    }

//    function3()

    println("test(0): ${test(0)}")
    println("test(1): ${test(1)}")
    println("test(2): ${test(2)}")
    println("test(3): ${test(3)}")

    println("testCatchOrder(2): ${testCatchOrder(2)}")
    println("testCatchOrder(3): ${testCatchOrder(3)}")

    try {
        testCode("A1".toInt(16))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        testCode("0".toInt(1))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        checkCode("A1".toInt(16))
    } catch (e: IncorrectInputException) {
        println(e.message)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        checkCode("0".toInt(1))
    } catch (e: IncorrectInputException) {
        println(e.message)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    listOf(10, -10).forEach {
        try {
            checkValue(it)
        } catch (e: IllegalArgumentException) {
            println("in catch clause for main()")
            println(e.message)
        }
    }

    println("testFinally(0): ${testFinally(0)}")
    println("testFinally(1): ${testFinally(1)}")

}