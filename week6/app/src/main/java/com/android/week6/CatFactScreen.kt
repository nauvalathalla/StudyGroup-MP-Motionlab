package com.android.week6

import androidx.compose.material3.* // Untuk Material3
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CatFactScreen(
    viewModel: CatFactViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (uiState) {
            is CatFactUiState.Initial -> {
                Text(
                    text = "Welcome to Cat Facts!",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            is CatFactUiState.Loading -> {
                CircularProgressIndicator()
            }
            is CatFactUiState.Success -> {
                val fact = (uiState as CatFactUiState.Success).fact
                Text(
                    text = fact.fact,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            is CatFactUiState.Error -> {
                Text(
                    text = (uiState as CatFactUiState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        Button(
            onClick = { viewModel.getNewFact() },
            enabled = uiState !is CatFactUiState.Loading
        ) {
            Text("Get New Fact")
        }
    }
}