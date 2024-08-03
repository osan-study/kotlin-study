import aa.DataFile



class Usable() : AutoCloseable {
    fun func() = println("func()")
    override fun close() {
        println("close()")
    }
}

fun main() {
    println(
        DataFile("Results.txt")
            .bufferedReader()
            .use { it.readLines().first() }
    )

    println(
        DataFile("Results.txt").useLines {
            it.filter { "#" in it }.first()
        }
    )

    println(
        DataFile("Results.txt").useLines {
            lines -> lines.filter {
                line -> "#" in line
            }.first()
        }
    )

    var str: String = ""
    DataFile("Results.txt").forEachLine {
        if ( it.startsWith("#") ) {
            str += it
        }
    }

    println(str)

    Usable().use { it.func() }

}