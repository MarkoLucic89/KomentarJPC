package com.example.komentarjpc.domain.model

data class News(
    var id: Int,
    var image: String,
    var categoryTitle: String,
    var categoryColor: String,
    var title: String,
    var createdAt: String,
    var url: String
)
