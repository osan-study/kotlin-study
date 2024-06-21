fun main() {
    var i = 0
    print("while:\t\t")
    while (condition(i)) {
        print(".")
        i += 10
    }

    println()
    i = 0

    print("do-while:\t")
    do {
        print(".")
        i += 10
    } while (condition(i))
    println()

    var n = 10
    val d = 3
    print(n)
    while (n > d) {
        n -= d
        print(" - $d")
    }
    println(" = $n")

    var m = 10
    print(m)
    m %= d
    println(" % $d = $m")

    var j = 0
    print("j++:\t\t")
    while (j < 4) {
        print(".")
        j++
    }
}

fun condition(i: Int) = i < 100