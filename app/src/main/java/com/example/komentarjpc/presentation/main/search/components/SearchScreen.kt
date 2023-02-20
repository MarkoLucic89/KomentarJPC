package com.example.komentarcompose.presentation.main.search.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.komentarjpc.presentation.main.search.viewmodel.SearchViewModel
import com.example.komentarjpc.common.Constants.TAG
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.presentation.common.components.NewsItemComposable
import com.example.komentarjpc.presentation.main.search.components.MainAppBar
import com.example.komentarjpc.presentation.main.search.components.SearchWidgetState

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState

    val state by viewModel.state

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    viewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onSearchClicked = { searchTerm ->
                    Log.d(TAG, "SearchScreen: SEARCH TEXT: $searchTerm")
                    viewModel.searchNews(searchTerm)
                },
                onSearchTriggered = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
                },
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            items(items = state.news) { news: News ->
                NewsItemComposable(
                    news = news,
                    onItemClick = {
                        Log.d(TAG, "VideosScreenComposable: ON NEWS CLICK: ${news.title}")
                    })
            }
        }


    }
}