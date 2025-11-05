package com.example.dailyquoteapp

class QuoteRepository {
    suspend fun getQuote(): Quote {
        return RetrofitInstance.api.getRandomQuote()
    }
}
