package com.example.komentarjpc.presentation.main.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komentarjpc.common.Resource
import com.example.komentarjpc.domain.use_case.get_categories.GetCategoriesUseCase
import com.example.komentarjpc.domain.use_case.get_videos.GetVideosUseCase
import com.example.komentarjpc.presentation.common.state.CategoryState
import com.example.komentarjpc.presentation.common.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetCategoriesUseCase
) : ViewModel() {
    private val _state
    = mutableStateOf<CategoryState>(CategoryState())
    val state: State<CategoryState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        getHomeUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CategoryState(categories = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        CategoryState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CategoryState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}