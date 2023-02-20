package com.example.komentarjpc.presentation.main.search.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komentarjpc.common.Resource
import com.example.komentarjpc.domain.use_case.search_news.SearchUseCase
import com.example.komentarjpc.presentation.common.state.NewsState
import com.example.komentarjpc.presentation.main.search.components.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
        searchNews(searchTextState.value)
    }

    private val _state = mutableStateOf<NewsState>(NewsState())
    val state: State<NewsState> = _state

    fun searchNews(searchTerm: String) {
        searchUseCase(searchTerm)
            .onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        NewsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = NewsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}