package chapter2.moonggae.atomic29

import atomictest.eq

private const val successMessage = "Successful move"
private const val invalidMessage = "Invalid move"

class Cell {
    var entry = ' '
    fun setValue(e: Char): String =
        if (entry == ' ' &&
            (e == 'X' || e == 'O')
        ) {
            entry = e
            successMessage
        } else invalidMessage
}

class Grid {
    val cells = listOf(
        listOf(Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell())
    )
    fun play(e: Char, x: Int, y: Int): String =
        if (x !in 0..2 || y !in 0..2) {
            invalidMessage
        } else {
            val result = cells[x][y].setValue(e)
            printGrid()
            result
        }

    private fun printGrid() {
        for (column in cells) {
            for (cell in column) {
                val entry = if (cell.entry == ' ') "□" else cell.entry
                print("$entry ")
            }
            println()
        }
    }
}

fun main() {
    val grid = Grid()
    grid.play('X', 1, 1) eq successMessage
    grid.play('O', 0, 0) eq successMessage
    grid.play('X', 1, 1) eq invalidMessage
    grid.play('O', 0, 3) eq invalidMessage
}