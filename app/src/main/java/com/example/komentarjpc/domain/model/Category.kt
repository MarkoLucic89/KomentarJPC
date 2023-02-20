package com.example.komentarjpc.domain.model

data class Category(
    var type: String,
    var id: Int,
    var name: String,
    var color: String,
    var subcategories: List<Category?>?
)
