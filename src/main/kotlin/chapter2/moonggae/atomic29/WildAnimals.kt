package chapter2.moonggae.atomic29

import atomictest.eq

fun main() {
    Badger("Bob", 11) eq "Badger: Bob, age: 11"
    Snake("Python", 3.5) eq "Snake: Python, length: 3.5"
    Moose(5, 6.5) eq "Moose, age: 5, height: 6.5"
}

class Badger(id: String, years: Int) {
    val name = id
    val age = years

    override fun toString(): String {
        return "Badger: $name, age: $age"
    }
}

class Snake(
    var type: String,
    var length: Double
) {
    override fun toString(): String {
        return "Snake: $type, length: $length"
    }
}

class Moose(
    val age: Int,
    val height: Double
) {
    override fun toString(): String {
        return "Moose, age: $age, height: $height"
    }
}