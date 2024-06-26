package chapter2.moonggae.atomic29

import atomictest.eq

class Holder(var i: Int)

fun main() {
    val holder = Holder(10)
    holder.i eq 10 // Read the 'i' property
    holder.i = 20  // Write to the 'i' property
}