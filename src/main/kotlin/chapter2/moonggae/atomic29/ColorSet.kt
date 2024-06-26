package chapter2.moonggae.atomic29

import atomictest.eq

val colors =
    "Yellow Green Green Blue"
        .split(Regex("""\W+""")).sorted()  // [1]

fun main() {
    colors eq
            listOf("Blue", "Green", "Green", "Yellow")
    val colorSet = colors.toSet()        // [2]
    colorSet eq
            setOf("Yellow", "Green", "Blue")
    (colorSet + colorSet) eq colorSet    // [3]
    val mSet = colorSet.toMutableSet()   // [4]
    mSet -= "Blue"
    mSet += "Red"                        // [5]
    mSet eq
            setOf("Yellow", "Green", "Red")
    // Set membership:
    ("Green" in colorSet) eq true        // [6]
    colorSet.contains("Red") eq false
}