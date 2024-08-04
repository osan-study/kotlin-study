package chapter6.moonggae.check

import atomictest.*
import java.io.File

val targetDir = File("DataFiles")

class DataFile(val fileName: String) :
    File(targetDir, fileName) {
    init {
        if (!targetDir.exists())
            targetDir.mkdir()
    }
    fun erase() { if (exists()) delete() }
    fun reset(): File {
        erase()
        createNewFile()
        return this
    }
}


val resultFile = DataFile("Results.txt")

fun createResultFile(create: Boolean) {
    if (create)
        resultFile.writeText("Results\n# ok")
    check(resultFile.exists()) {
        "${resultFile.name} doesn't exist!"
    }
}

fun main() {
    resultFile.erase()
    capture {
        createResultFile(false)
    } eq "IllegalStateException: " +
            "Results.txt doesn't exist!"
    createResultFile(true)
}