import kotlin.random.Random

data class Tag(var n: Int = 0) {
    var s: String = ""
    fun increment() = ++n
}

fun gets(): String? = if(Random.nextBoolean()) "str!" else null


class Gnome(val name: String) {
    fun who() = "gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let {it.who()}
    gnome.let {it?.who()}
    gnome?.run {who()}
    gnome.run {this?.who()}
    gnome?.apply{who()}
    gnome.apply{this?.who()}
    gnome?.also{it.who()}
    gnome.also{it?.who()}
    with(gnome) {this?.who()}
}

fun whichGnome(gnome: Gnome?) {
    println(gnome?.name)
    gnome?.let { println(it.who()) }
    gnome?.run { println(who()) }
    gnome?.apply { println(who()) }
    gnome?.also { println(it.who()) }
}

fun main() {
    println("Tag(1).let {\n" +
            "        it.s = \"let: \${it.n}\"\n" +
            "        it.increment()\n" +
            "    }: ${Tag(1).let {
                it.s = "let: ${it.n}"
                it.increment()
            }}")


    println("Tag(1).run {\n" +
            "        s = \"let: \$n\"\n" +
            "        increment()\n" +
            "    }: ${Tag(1).run {
                s = "let: $n"
                increment()
            }}")

    println("with(Tag(1)) {\n" +
            "        s = \"let: \$n\"\n" +
            "        increment()\n" +
            "    }: ${with(Tag(1)) {
                s = "let: $n"
                increment()
            }}")

    println("Tag(1).apply {\n" +
            "        s = \"let: \$n\"\n" +
            "        increment()\n" +
            "    }: ${Tag(1).apply {
                s = "let: $n"
                increment()
            }}")

    println("Tag(1).also {\n" +
            "        it.s = \"let: \$n\"\n" +
            "        it.increment()\n" +
            "    }: ${Tag(1).also {
                it.s = "let: ${it.n}"
                it.increment()
            }}")

    println("gets()?.let {\n" +
            "        it.removeSuffix(\"!\") + it.length\n" +
            "    }: ${gets()?.let {
                it.removeSuffix("!") + it.length
            }}")

    whichGnome(Gnome("bob"))
    whichGnome(null)
}