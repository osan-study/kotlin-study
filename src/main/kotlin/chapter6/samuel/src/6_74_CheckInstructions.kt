package aa;

import java.io.File
import kotlin.math.sqrt

data class Month(val monthNumber: Int) {
    init {
        require(monthNumber in 1..12) {
            "monthNumber should be between 1 and 12"
        }
    }
}

class Roots(
    val root1: Double,
    val root2: Double
)

fun quadraticZeroes (
    a: Double,
    b: Double,
    c: Double
): Roots {
    require(a != 0.0) {
        "a is zero"
    }
    val underRadical = b * b - 4 * a * c
    require(underRadical >= 0) {
        "Negative underRadical : $underRadical"
    }
    val squareRoot = sqrt(underRadical)
    val root1 = (-b - squareRoot) / 2 * a
    val root2 = (-b + squareRoot) / 2 * a
    return Roots(root1, root2)
}

val targetDir = File("DataFiles")

class DataFile(val fileName: String) : File(targetDir, fileName) {
    init {
        if(!targetDir.exists()) {
            targetDir.mkdirs()
        }
    }
    fun erase() {
        if (exists())
            delete()
    }

    fun reset(): File {
        erase()
        createNewFile()
        return this
    }
}

fun getTrace(fileName: String): List<String> {
    require(fileName.startsWith("file_")) {
        "$fileName must start with file_"
    }

    val file = DataFile(fileName)
    require(file.exists()) {
        "$fileName does not exist."
    }

    val lines = file.readLines()
    require(lines.isNotEmpty()) {
        "$fileName is empty"
    }
    return lines
}

fun singleArgRequire(arg: Int): Int {
    require(arg > 5)
    return arg
}

fun notNull(n: Int?): Int {
    requireNotNull(n) {
        "notNull() argument cannot be null"
    }
    return n * 9
}

val resultFile = DataFile("Results.txt")

fun creatResultFile(create: Boolean) {
    if(create)
        resultFile.writeText("Results\n# Ok")
    check(resultFile.exists()) {
        "${resultFile.name} does not exist."
    }
}

fun main() {
    Month(1)
    try {
        Month(13)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        quadraticZeroes(0.0, 4.0, 5.0)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        quadraticZeroes(3.0, 4.0, 5.0)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    val roots = quadraticZeroes(1.0, 2.0, -8.0)
    println("roots.root1: ${roots.root1}")
    println("roots.root2: ${roots.root2}")

    DataFile("Test.txt").reset()

    DataFile("file_empty.txt").writeText("")
    DataFile("file_wubba.txt").writeText("wubba lubba dub dub")

    try {
        getTrace("wrong_name.txt")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        getTrace("file_nonexistent.txt")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        getTrace("file_empty.txt")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        println("getTrace(\"file_wubba.txt\"): ${getTrace("file_wubba.txt")}")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        singleArgRequire(5)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    println("singleArgRequire(6): ${singleArgRequire(6)}")

    val n: Int? = null
    try {
        notNull(n)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    try {
        requireNotNull(n)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    println("notNull(11): ${notNull(11)}")

    resultFile.erase()
    try {
        creatResultFile(false)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    creatResultFile(true)
}