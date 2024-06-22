class Default {
    var i: Int = 0
        get() {
            println("in get()")
            return field
        }
        set(value) {
            println("in set(value)")
            field = value
        }
}

class Default2 {
    var i: Int = 0
        get() {
            println("in get()")
            return field
        }
        private set
    fun mySet(i: Int) {
        println("in mySet")
        this.i += i
    }
}
fun main() {

    val d = Default()
    d.i = 2
    println("d.i: ${d.i}")

    val d2 = Default2()
//    d2.i = 2
    d2.mySet(2)
    println("d2.i: ${d2.i}")

}