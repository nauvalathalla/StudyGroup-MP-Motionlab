package com.android.week6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CatFactUiState>(CatFactUiState.Initial)
    val uiState = _uiState.asStateFlow()

    init {
        getNewFact()
    }

    fun getNewFact() {
        viewModelScope.launch {
            _uiState.value = CatFactUiState.Loading
            try {
                val fact = RetrofitInstance.api.getRandomFact()
                _uiState.value = CatFactUiState.Success(fact)
            } catch (e: Exception) {
                _uiState.value = CatFactUiState.Error("Error: ${e.message}")
            }
        }
    }
}
