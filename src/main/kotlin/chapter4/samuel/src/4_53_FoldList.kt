fun main() {

    val list = listOf(1, 10, 100, 1000)
    println("list.fold(0) { sum, n -> sum + n }: ${list.fold(0) { sum, n -> sum + n }}")

    val listStar = listOf("*", "A", "B", "C", "D")
    val listWithoutStar = listOf("A", "B", "C", "D")

    println("listWithoutStar.fold(\"*\") { acc, n -> \"\$acc \$n\" }: ${listWithoutStar.fold("*") { acc, n -> "$acc $n" }}")
    println("listStar.reduce { acc, n -> \"\$acc \$n\" }: ${listStar.reduce { acc, n -> "$acc $n" }}")

    println("listWithoutStar.runningFold(\"*\") { acc, n -> \"\$acc \$n\" }: ${listWithoutStar.runningFold("*") { acc, n -> "$acc $n" }}")
    println("listStar.runningReduce { acc, n -> \"\$acc \$n\" }: ${listStar.runningReduce { acc, n -> "$acc $n" }}")

}