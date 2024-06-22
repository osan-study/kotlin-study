import atomictest.eq

fun main() {

    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    constants["e"] eq 2.718
    constants.keys eq setOf("Pi", "e", "phi")
    constants.values eq "[3.141, e=2.718, phi=1.618]"

    var s = ""

    for (entry in constants) {
        s += "${entry.key} = ${entry.value}, "
    }
    s eq "Pi = 3.141, e = 2.718, phi = 1.618,"

    s = ""
    for ((key, value) in constants) {
        s += "${key} = ${value}, "
    }
    s eq "Pi = 3.141, e = 2.718, phi = 1.618,"

    val m = mutableMapOf(5 to "five", 6 to "six")

    m[5] eq "five"
    m[5] = "5ive"
    m[5] eq "5ive"
    m[4] = "four"
    m eq mapOf(5 to "5ive", 6 to "six", 4 to "four")
    m.getOrDefault(2, "no item") eq "no item"
}