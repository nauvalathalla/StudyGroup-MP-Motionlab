package com.android.week6

sealed class CatFactUiState {
    object Initial : CatFactUiState()
    object Loading : CatFactUiState()
    data class Success(val fact: CatFact) : CatFactUiState()
    data class Error(val message: String) : CatFactUiState()
}