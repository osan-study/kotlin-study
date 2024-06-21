class Cookie(private var isReady: Boolean) {

    private fun crumble() = println("crumble")

    public fun bite() = println("bite")

    fun eat() {
        isReady = true
        crumble()
        bite()
    }

}

class Counter(var start: Int) {
    fun increment() {
        start += 1
    }
    override fun toString() = start.toString()
}

class CounterHolder(counter: Counter) {
    private val ctr = counter
    override fun toString() = "CounterHolder: " + ctr
}

fun main() {
    val cookies = Cookie(false)
    cookies.bite()
    cookies.eat()

    val counter = Counter(11)
    val counterHolder = CounterHolder(counter)
    println(counterHolder)
    counter.increment()
    println(counterHolder)
    val ch2 = CounterHolder(Counter(9))
    println(ch2)
}