package com.example.komentarjpc.presentation.common.state

import com.example.komentarjpc.domain.model.News

data class NewsState(
    val isLoading: Boolean = false,
    val news: List<News> = emptyList(),
    val error: String = ""
)