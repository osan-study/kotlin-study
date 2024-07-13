
fun interface Counter2 {
    fun next(): Int
}

object CounterFactory {
    private var count = 0
    fun new(name: String): Counter2 {
        class Local : Counter2 {
            init {
                println("Local()")
            }
            override fun next(): Int {
                println("$name $count")
                return count++
            }
        }
        return Local()
    }
    fun new2(name: String): Counter2 {
        return object : Counter2 {
            init {
                println("Counter2()")
            }
            override fun next(): Int {
                println("$name $count")
                return count++
            }
        }
    }

    fun new3(name: String): Counter2 {
        println("Counter2()")
        return Counter2 {
            println("$name $count")
            count++
        }
    }
}


fun main() {
    fun test(counter: Counter2) {
        (0..3).forEach{counter.next()}
    }
    print("test(CounterFactory.new(\"Local\")): ")
    test(CounterFactory.new("Local"))
    print("test(CounterFactory.new2(\"Anon\")): ")
    test(CounterFactory.new2("Anon"))
    print("test(CounterFactory.new3(\"SAM\")): ")
    test(CounterFactory.new3("SAM"))
}