package com.example.komentarjpc.data.remote.dto

import com.example.komentarjpc.domain.model.News

data class NewsDto(
    var id: Int,
    var image: String,
    var image_source: String,
    var author_name: String,
    var source: String,
    var category: CategoryDto,
    var title: String,
    var description: String,
    var comment_enabled: Int,
    var comments_count: Int,
    var shares_count: Int,
    var created_at: String,
    var url: String,
    var click_type: String
)

fun NewsDto.toNews(): News {
    return News(
        id = id,
        image = image,
        categoryTitle = category.name,
        categoryColor = category.color,
        title = title,
        createdAt = created_at,
        url = url
    )
}
