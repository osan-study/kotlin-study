//open class Transport

sealed class Transport

data class Train(
    val line: String
) : Transport()

data class Bus(
    val number: String,
    val capacity: Int
) : Transport()

//data class Airplane(
//    val name: String
//) : Transport()

fun travel(transport: Transport) =
    when (transport) {
        is Train -> "Train ${transport.line}"
        is Bus -> "Bus ${transport.number}: size ${transport.capacity}"
        // else -> "$transport is in limbo!"
    }


abstract class Abs(val av: String) {
    open fun concreteFunction() {}
    open val concreteProperty = ""
    abstract fun absFunc(): String
    abstract val absProp: String
    init {}
    constructor(c: Char) : this(c.toString()) {}
}

open class Concrete() : Abs("") {
    override fun concreteFunction() {}
    override val concreteProperty = ""
    override fun absFunc() = ""
    override val absProp = ""
}

sealed class Sealed(val av: String) {
    open fun concreteFunction() {}
    open val concreteProperty = ""
    abstract fun absFunc(): String
    abstract val absProp: String
    init {}
    constructor(c: Char) : this(c.toString()) {}
}

open class SealedSubclass() : Sealed("") {
    override fun concreteFunction() {}
    override val concreteProperty = ""
    override fun absFunc() = ""
    override val absProp = ""
}

sealed class Top
class Middle1 : Top()
class Middle2 : Top()
open class Middle3 : Top()
class Bottom3 : Middle3()

fun main() {
    println("listOf(Train(\"S1\"), Bus(\"11\", 90)).map(::travel): ${listOf(Train("S1"), Bus("11", 90)).map(::travel)}")

    Concrete()
    SealedSubclass()

    println("Top::class.sealedSubclasses.map { it.simpleName }: ${Top::class.sealedSubclasses.map { it.simpleName }}")
}