package chapter5.moonggae.nested

import atomictest.eq

interface Item {
    val type: Type
    data class Type(val type: String)
}

class Bolt(type: String) : Item {
    override val type = Item.Type(type)
}

fun main() {
    val items = listOf(
        Bolt("Slotted"), Bolt("Hex")
    )
    items.map(Item::type) eq
            "[Type(type=Slotted), Type(type=Hex)]"
}