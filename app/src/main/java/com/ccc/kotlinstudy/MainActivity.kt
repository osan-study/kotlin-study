package com.ccc.kotlinstudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ccc.kotlinstudy.ui.theme.KotlinStudyTheme
import com.ccc.kotlinstudy.util.conditional

class MainActivity : ComponentActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[TicTacToeViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TicTacToeScreen(Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

@Composable
fun TicTacToeScreen(
    modifier: Modifier = Modifier,
    viewModel: TicTacToeViewModel = TicTacToeViewModel()
) {
    val scope = rememberCoroutineScope()
    val gameUiState by viewModel.uiState.collectAsState()
    var errorMessage: String? by remember { mutableStateOf(null) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Current Player: ${gameUiState.currentPlayer}", modifier = Modifier.padding(12.dp))

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .aspectRatio(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            gameUiState.grid.forEachIndexed { y, columns ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    columns.forEachIndexed { x, _ ->
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .weight(1f)
                                .aspectRatio(1f)
                        ) {
                            Text(
                                text = gameUiState.grid[x][y]?.name ?: "",
                                textAlign = TextAlign.Center,
                                fontSize = 36.sp,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .conditional(gameUiState.winner == null) {
                                        clickable {
                                            scope
                                                .runCatching {
                                                    viewModel.play(x, y)
                                                    errorMessage = null
                                                }
                                                .onFailure {
                                                    errorMessage = it.message
                                                }
                                        }
                                    }
                                    .wrapContentHeight()
                            )
                        }
                    }
                }
            }
        }

        if (gameUiState.isGameOver) {
            if (gameUiState.winner == null) {
                Text(
                    text = "It's a tie!",
                    modifier = Modifier.padding(20.dp)
                )
            } else {
                Text(
                    text = "Winner: ${gameUiState.winner?.name}",
                    modifier = Modifier.padding(20.dp)
                )
            }

            Button(onClick = viewModel::reset) {
                Text(text = "Reset")
            }
        } else {
            Text(
                text = errorMessage ?: "",
                modifier = Modifier.padding(20.dp),
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}