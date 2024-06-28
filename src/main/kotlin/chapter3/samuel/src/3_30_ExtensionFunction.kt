fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""

class Book(val title: String)

fun Book.categorize(category: String) = """title: "$title", category: $category"""

fun main() {
    println("\"Hi\".singleQuote() == \"'Hi'\": ${"Hi".singleQuote() == "'Hi'"}")
    println("\"Hi\".doubleQuote() == \"\"Hi\"\": ${"Hi".doubleQuote() == "\"Hi\""}")
    println("Book(\"Samuel\").categorize(\"Worker\") == \"\"\"title: \"Samuel\", category: Worker\"\"\": ${Book("Samuel").categorize("Worker") == """title: "Samuel", category: Worker"""}")
}

