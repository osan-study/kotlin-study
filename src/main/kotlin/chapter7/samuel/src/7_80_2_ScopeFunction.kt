
data class Plumbus(var id: Int)

fun display(map: Map<String, Plumbus>) {
    println("displaying $map")
    val pb1: Plumbus = map["main"]?.let {
        it.id += 10
        it
    } ?: return

    println(pb1)

    val pb2: Plumbus? = map["main"]?.run {
        id += 9
        this
    }

    println(pb2)

    val pb3: Plumbus? = map["main"]?.apply {
        id += 8
    }

    println(pb3)

    val pb4: Plumbus? = map["main"]?.also {
        it.id += 7
    }

    println(pb4)

}

val functions = listOf(
    fun(name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.let { println("$it in let") }
    },
    fun(name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.run { println("$this in run") }
    },
    fun(name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.apply { println("$this in run") }
    },
    fun(name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.also { println("$it in run") }
    }
)

data class Blob(val id: Int) : AutoCloseable {
    override fun toString() = "blob($id)"
    fun show() { println("$this") }
    override fun close() = println("close $this")
}

fun main() {
    display(mapOf("main" to Plumbus(1)))
    display(mapOf("none" to Plumbus(2)))

    functions.forEach { it(null) }
    functions.forEach { it(" ") }
    functions.forEach { it("Yumyulack") }

    Blob(1).let { it.show() }
    Blob(2).run { show() }
    with(Blob(3)) { show() }
    Blob(4).apply { show() }
    Blob(5).also { it.show() }
    Blob(6).use { it.show() }
    Blob(7).use { it.run { show() }}
    Blob(8).apply { show() }.also { it.close() }
    Blob(9).also { it.show() }.apply { close() }
    Blob(10).apply { show() }.close()

}