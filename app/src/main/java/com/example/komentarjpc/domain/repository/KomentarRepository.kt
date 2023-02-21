package com.example.komentarjpc.domain.repository

import com.example.komentarjpc.data.remote.dto.CategoriesResponseModel
import com.example.komentarjpc.data.remote.dto.NewsResponseModel

interface KomentarRepository {

    suspend fun getLatest(page: Int, rows: Int): NewsResponseModel

    suspend fun getVideos(page: Int): NewsResponseModel

    suspend fun searchNews(searchTerm: String, page: Int): NewsResponseModel

    suspend fun getCategories(): CategoriesResponseModel
}