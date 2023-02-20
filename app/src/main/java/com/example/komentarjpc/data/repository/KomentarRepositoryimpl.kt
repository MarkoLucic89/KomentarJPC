package com.example.komentarjpc.data.repository

import com.example.komentarjpc.data.remote.KomentarApi
import com.example.komentarjpc.data.remote.dto.NewsResponseModel
import com.example.komentarjpc.domain.repository.KomentarRepository
import javax.inject.Inject

class KomentarRepositoryimpl @Inject constructor(
    private val api: KomentarApi
) : KomentarRepository {

    override suspend fun getLatest(page: Int, rows: Int): NewsResponseModel {
        return api.getLatest(page, rows)
    }

    override suspend fun getVideos(page: Int): NewsResponseModel {
        return api.getVideos(page)
    }

    override suspend fun searchNews(searchTerm: String, page: Int): NewsResponseModel {
        return api.searchNews(searchTerm, page)
    }


}