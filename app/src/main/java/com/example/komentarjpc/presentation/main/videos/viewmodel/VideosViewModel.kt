package com.example.komentarjpc.presentation.main.videos.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komentarjpc.common.Resource
import com.example.komentarjpc.domain.use_case.get_videos.GetVideosUseCase
import com.example.komentarjpc.presentation.common.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase
) : ViewModel() {
    private val _state = mutableStateOf<NewsState>(NewsState())
    val state: State<NewsState> = _state

    init {
        getVideos()
    }

    private fun getVideos() {
        getVideosUseCase().onEach { result ->
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