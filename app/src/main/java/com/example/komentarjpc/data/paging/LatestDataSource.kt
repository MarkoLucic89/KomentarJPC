package com.example.komentarjpc.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.komentarjpc.data.remote.dto.toNews
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.domain.repository.KomentarRepository

class LatestDataSource(
    private val repository: KomentarRepository
) : PagingSource<Int, News>() {

    override fun getRefreshKey(state: PagingState<Int, News>): Int? =
        state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> =
        try {
            val page = params.key ?: 1
            val response = repository.getLatest(page, 20)
            LoadResult.Page(
                data = response.data.news.map { it.toNews() },
                prevKey = null,
                nextKey = if (response.data.pagination.has_more_pages) {
                    response.data.pagination.current_page + 1
                } else {
                    null
                }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

}