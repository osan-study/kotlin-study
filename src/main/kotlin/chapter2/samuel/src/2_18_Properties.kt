class Cup {
    var percentFull = 0
}

class Cup2 {
    var percentFull = 0
    val max = 100

    fun add(increse: Int): Int {
        percentFull += increse
        if(percentFull > max) {
            percentFull = max
        }
        return percentFull
    }
}

class Kitchen {
    var table: String = "Round Table"
}

fun main() {
    val c1 = Cup()
    println("c1.percentFull: ${c1.percentFull}")
    c1.percentFull = 50
    println("c1.percentFull = 50")
    println("c1.percentFull: ${c1.percentFull}")

    val c2 = Cup()
    println("c2.percentFull: ${c2.percentFull}")
    c2.percentFull = 100
    println("c2.percentFull = 100")
    println("c2.percentFull: ${c2.percentFull}")

    val c3 = Cup2()
    c3.add(50)
    println("c3.add(50)")
    println("c3.percentFull: ${c3.percentFull}")
    c3.add(70)
    println("c3.add(70)")
    println("c3.percentFull: ${c3.percentFull}")

    val kitchen1 = Kitchen()
    val kitchen2 = kitchen1
    println("kitchen1.table: ${kitchen1.table}")
    println("kitchen2.table: ${kitchen2.table}")
    kitchen1.table = "Square Table"
    println("kitchen1.table: ${kitchen1.table}")
    println("kitchen2.table: ${kitchen2.table}")
}
