fun main() {

    val million = 1_000_000
    println("million: $million")

    val numerator: Int = 19
    val denominator: Int = 10
    println("numerator % denominator = ${numerator % denominator}")

    println("45 + 5 * 6 = ${45 + 5 * 6}")
    println("(45 + 5) * 6 = ${(45 + 5) * 6}")

    val weight = 72.57
    val height = 1.727
    val status = bmiMetric(weight, height)
    println("bmiMetric(weight, height): $status")

    val weight2 = 160
    val height2 = 68
    val status2 = bmiEnglish(weight2, height2)
    println("bmiEnglish(weight2, height2): $status2")

    val i: Int = Int.MAX_VALUE
    println("Int.MAX_VALUE + 1: ${i + 1}")

    // L을 통한 Long 타입 지정
    val l1 = 0L
    // Long 타입 명시
    val l2: Long = 0
    println("l1, l2: $l1, $l2")

    val preventOverflow = Int.MAX_VALUE
    println("0L + preventOverflow + 1: ${0L + preventOverflow + 1}")
    println("1_000_000 * 1_000_000L: ${1_000_000 * 1_000_000L}")

    println("Long.MAX_VALUE: ${Long.MAX_VALUE}")
}

fun bmiMetric(weight: Double, height: Double): String {
    val bmi = weight / (height * height)
    return if (bmi < 18.5) "Under Weight"
        else if (bmi <= 25) "Normal Weight"
        else "Over Wight"
}

fun bmiEnglish(weight: Int, height: Int): String {
    val bmi = 703.07 * weight / (height * height)
    return if (bmi < 18.5) "Under Weight"
    else if (bmi <= 25) "Normal Weight"
    else "Over Wight"
}