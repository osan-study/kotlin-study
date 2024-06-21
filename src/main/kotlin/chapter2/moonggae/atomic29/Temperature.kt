package chapter2.moonggae.atomic29

import atomictest.eq

fun main() {
    val temp = Temperature()
    temp.setFahrenheit(98.6)
    temp.getFahrenheit() eq 98.6
    temp.getCelsius() eq 37.0
    temp.setCelsius(100.0)
    temp.getFahrenheit() eq 212.0
    temp.getCelsius() eq 100.0
}

class Temperature {
    var current = 0.0
    var scale = "f"
    fun setFahrenheit(now: Double) {
        current = now
        scale = "f"
    }
    fun setCelsius(now: Double) {
        current = now
        scale = "c"
    }
    fun getFahrenheit(): Double {
        return if (scale == "f") current else current * 9.0 / 5.0 + 32.0
    }

    fun getCelsius(): Double {
        return if (scale == "c") current else (current - 32.0) * 5.0 / 9.0
    }
}