package chapter6.moonggae.unittest

enum class Language {
    Kotlin, Java, Go, Python, Rust, Scala
}

data class Learner(
    val id: Int,
    val name: String,
    val surname: String,
    val language: Language
)
