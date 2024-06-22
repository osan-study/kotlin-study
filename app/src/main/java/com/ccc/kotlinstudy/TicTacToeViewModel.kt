package com.ccc.kotlinstudy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Player {
    X, O
}

class InvalidMoveException : IllegalArgumentException("Invalid move")

class TicTacToeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeUiState())
    val uiState: StateFlow<TicTacToeUiState> = _uiState

    fun play(x: Int, y: Int) {
        play(uiState.value.currentPlayer, x, y)
    }

    private fun play(player: Player, x: Int, y: Int) {
        if (x !in 0..2 || y !in 0..2) {
            throw InvalidMoveException()
        }
        if (_uiState.value.grid[x][y] != null) {
            throw InvalidMoveException()
        }
        viewModelScope.launch {
            _uiState.update { state ->
                val nextPlayer = if (player == Player.X) Player.O else Player.X
                state.copy(
                    grid = state.grid.mapIndexed { rowIndex, row ->
                        row.mapIndexed { colIndex, cell ->
                            if (rowIndex == x && colIndex == y) player else cell
                        }
                    },
                    currentPlayer = nextPlayer
                )
            }
        }
    }


    fun reset() {
        _uiState.value = TicTacToeUiState()
    }
}

data class TicTacToeUiState(
    val currentPlayer: Player = Player.X,
    val grid: List<List<Player?>> = EMPTY_GRID.toMutableList()
) {
    val winner: Player? get() {
        // 가로, 세로, 대각선 방향으로 승자 확인
        // 가로 방향 확인
        for (row in grid) {
            if (row[0] != null && row[0] == row[1] && row[1] == row[2]) {
                return row[0]
            }
        }

        // 세로 방향 확인
        for (col in 0..2) {
            if (grid[0][col] != null && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                return grid[0][col]
            }
        }

        // 대각선 방향 확인
        if (grid[0][0] != null && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0]
        }
        if (grid[0][2] != null && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2]
        }

        // 승자가 없는 경우
        return null
    }

    private val isGridFull: Boolean get() = grid.all { row -> row.all { it != null } }
    val isGameOver: Boolean get() = winner != null || isGridFull

    companion object {
        val EMPTY_GRID: List<MutableList<Player?>> = listOf(
            mutableListOf(null, null, null),
            mutableListOf(null, null, null),
            mutableListOf(null, null, null)
        )
    }
}