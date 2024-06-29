package chapter3.moonggae

private const val SUPER_STUDENT_NAME = "choi"

class Student(
    val name: String,
    val score: Int
) {
    val grade: String get() = when {
        name == SUPER_STUDENT_NAME -> "S"
        score >= 95 -> "A+"
        score >= 90 -> "A"
        score == 93 -> "S"
        score >= 85 -> "B+"
        score >= 80 -> "B"
        else -> "F"
    }
}

fun main() {
    val kim = Student(
        name = "kim",
        score = 100
    )

    val lee = Student(
        name = "lee",
        score = 93
    )

    val park = Student(
        name = "park",
        score = 79
    )

    val choi = Student(
        name = SUPER_STUDENT_NAME,
        score = 64
    )

    println("${kim.name}: ${kim.grade}")
    println("${lee.name}: ${lee.grade}")
    println("${park.name}: ${park.grade}")
    println("${choi.name}: ${choi.grade}")
}