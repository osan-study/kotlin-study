package chapter2.moonggae.atomic29

import atomictest.*

fun main() {
    trace("Hello,")
    trace(47)
    trace("world!")
    trace eq """
        Hello,
        47
        world!
    """
}