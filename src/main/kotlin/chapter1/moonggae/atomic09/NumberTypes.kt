package chapter1.moonggae.atomic09

import chapter1.moonggae.util.runExample

fun main() {
    runExample(::inferInt)
    runExample(::modulus)
    runExample(::intDivisionTruncates)
    runExample(::operatorOrder)
    runExample(::operatorOrderParens)
    runExample(::calculateBmiMetric)
    runExample(::calculateBmiEnglish)
    runExample(::integerOverflow)
    runExample(::longConstants)
    runExample(::usingLongs)
    runExample(::biggestLong)
}

fun inferInt() {
    // 가독성을 위해 숫자 사이 _ 허용
    val million = 1_000_000
    println(million)
}

fun modulus() { // 나머지
    val numerator: Int = 19
    val denominator: Int = 10
    println("19 % 10: ${numerator % denominator}")
}

fun intDivisionTruncates() {
    val numerator: Int = 19
    val denominator: Int = 10
    println("19 / 10: ${numerator / denominator}")
}

fun operatorOrder() {
    println("45 + 5 * 6: ${45 + 5 * 6}")
}

fun operatorOrderParens() {
    println("(45 + 5) * 6: ${(45 + 5) * 6}")
}

fun calculateBmiMetric() {
    fun bmiMetric(
        weight: Double,
        height: Double
    ): String {
        val bmi = weight / (height * height)
        println("bmi: $bmi")
        return if (bmi < 18.5) "저체중"
        else if (bmi < 25) "정상 체중"
        else "과체중"
    }

    val weight = 72.57 // 160 lbs
    val height = 1.727 // 68 inches
    val status = bmiMetric(weight, height)
    println(status)
}

fun calculateBmiEnglish() {
    fun bmiEnglish(
        weight: Int,
        height: Int
    ): String {
        val bmi = 703.07 * weight / (height * height)
        println("bmi: $bmi")
        return if (bmi < 18.5) "저체중"
        else if (bmi < 25) "정상 체중"
        else "과체중"
    }

    val weight = 160
    val height = 68
    val status = bmiEnglish(weight, height)
    println(status)
}

fun integerOverflow() {
    val i: Int = Int.MAX_VALUE
    println(i + i)
}

fun longConstants() {
    val i = 0
    val l1 = 0L
    val l2: Long = 0

    println("$l1 $l2")
}

fun usingLongs() {
    val i = Int.MAX_VALUE
    println(0L + i + i)
    println(1_000_000 * 1_000_000L)
}

fun biggestLong() {
    println(Long.MAX_VALUE)
}