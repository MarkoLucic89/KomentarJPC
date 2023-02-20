package com.example.komentarjpc.presentation.main.latest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.komentarjpc.data.paging.LatestDataSource
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.domain.repository.KomentarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LatestViewModel @Inject constructor(
    private val repository: KomentarRepository
) : ViewModel() {

    val latestPager = Pager(PagingConfig(pageSize = 20)) {
        LatestDataSource(repository = repository)
    }.flow.cachedIn(viewModelScope)

}