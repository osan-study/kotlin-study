package chapter4.moonggae

fun main() {
    val chars = "A B C D E".split(" ")

    val fold = chars.fold("*") { acc, e -> "$acc $e" }
    println("fold: $fold")

    val foldRight = chars.foldRight("*") { e, acc -> "$acc $e" }
    println("foldRight: $foldRight")

    val reduce = chars.reduce { acc, e -> "$acc $e" }
    println("reduce: $reduce")

    val reduceRight = chars.reduceRight { e, acc -> "$acc $e" }
    println("reduceRight: $reduceRight")

    val runningFold = chars.runningFold("*") { acc, e -> "$acc $e" }
    println("runningFold: $runningFold")

    val runningReduce = chars.runningReduce { acc, e -> "$acc $e" }
    println("runningReduce: $runningReduce")
}