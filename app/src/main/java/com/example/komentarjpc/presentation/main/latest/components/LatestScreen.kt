package com.example.komentarjpc.presentation.main.latest.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.komentarjpc.presentation.main.latest.viewmodel.LatestViewModel
import com.example.komentarjpc.R
import com.example.komentarjpc.common.Constants
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.presentation.common.components.NewsBigItemComposable
import com.example.komentarjpc.presentation.common.components.NewsItemComposable

@Composable
fun LatestScreen(
    viewModel: LatestViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {

            items(items = state.news) { news: News ->

                if (state.news.indexOf(news) == 0) {

                    NewsBigItemComposable(
                        news = news,
                        onItemClick = {
                            Log.d(
                                Constants.TAG,
                                "VideosScreenComposable: ON NEWS CLICK: ${it.title}"
                            )
                        })

                } else {

                    NewsItemComposable(
                        news = news,
                        onItemClick = {
                            Log.d(
                                Constants.TAG,
                                "VideosScreenComposable: ON NEWS CLICK: ${it.title}"
                            )
                        })
                }

            }

        }

        if (state.error.isNotBlank()) {
            Icon(
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = "Refresh icon",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

}