package com.example.dailyquoteapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val repository = QuoteRepository()

    var quote by mutableStateOf<Quote?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchQuote()  // 啟動時自動載入
    }

    fun fetchQuote() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                quote = repository.getQuote()
            } catch (e: Exception) {
                errorMessage = "載入失敗: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}