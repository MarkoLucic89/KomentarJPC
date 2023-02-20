package com.example.komentarjpc.domain.use_case.search_news

import com.example.komentarjpc.common.Resource
import com.example.komentarjpc.data.remote.dto.toNews
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.domain.repository.KomentarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repository: KomentarRepository
) {
    operator fun invoke(searchTerm: String): Flow<Resource<List<News>>> = flow {

        try {
            emit(Resource.Loading())
            val news = repository.searchNews(searchTerm, 0).data.news.map { it.toNews() }
            emit(Resource.Success(news))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server, check your internet connection"))
        }
    }
}