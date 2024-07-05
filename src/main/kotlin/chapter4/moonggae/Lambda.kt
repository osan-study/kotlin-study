package chapter4.moonggae

fun main() {
    val text = "`mcqnhc"
    val newText = text.map { // [4]
        val textChar: Char = it // [3]
        textChar + 1 // [2]
    }

    newText.mapIndexed { _, c -> // [5]
        print(c)
    }
}