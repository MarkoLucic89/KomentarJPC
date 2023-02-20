package com.example.komentarjpc.data.remote.dto

import com.example.komentarjpc.domain.model.Category

data class CategoryDto(
    var type: String,
    var id: Int,
    var name: String,
    var color: String,
    var main_image: String,
    var description: String,
    var subcategory: CategoryDto? = null,
    var subcategories: List<CategoryDto?>? = null
)

fun CategoryDto.toCategory(): Category {
    return Category(
        type = type,
        id = id,
        name = name,
        color = color,
        subcategories = subcategories!!.map { it!!.toCategory() }
    )

}