package com.example.komentarjpc.data.remote

import com.example.komentarjpc.data.remote.dto.NewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query


interface KomentarApi {

    @GET("api/videos")
    suspend fun getVideos(
        @Query("page") page: Int
    ): NewsResponseModel

    @GET("api/latest")
    suspend fun getLatest(
        @Query("page") page: Int,
        @Query("rows") rows: Int
    ): NewsResponseModel

    @GET("api/search")
    suspend fun searchNews(
        @Query("search_parameter") searchParameter: String,
        @Query("page") page: Int
    ): NewsResponseModel


}

