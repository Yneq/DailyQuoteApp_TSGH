package com.example.dailyquoteapp

data class Quote(
    val _id: String = "",
    val content: String = "",
    val author: String = "",
    val authorSlug: String = "",
    val length: Int = 0,
    val tags: List<String> = emptyList()
)
