package com.example.komentarjpc.presentation.common.state

import com.example.komentarjpc.domain.model.Category

data class CategoryState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)