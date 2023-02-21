package com.example.komentarjpc.presentation.main.latest.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.komentarjpc.common.Constants
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.presentation.common.LoadingListItem
import com.example.komentarjpc.presentation.common.components.ErrorListItem
import com.example.komentarjpc.presentation.common.components.NewsBigItemComposable
import com.example.komentarjpc.presentation.common.components.NewsItemComposable
import com.example.komentarjpc.presentation.main.latest.viewmodel.LatestViewModel

@Composable
fun LatestScreen(
    viewModel: LatestViewModel = hiltViewModel()
) {
    val latestNewsList: LazyPagingItems<News> = viewModel.latestPager.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        LazyColumn {

            items(latestNewsList) { news ->
                if (latestNewsList[0]?.id == news?.id) {
                    NewsBigItemComposable(
                        news = news!!,
                        onItemClick = {
                            Log.d(
                                Constants.TAG,
                                "VideosScreenComposable: ON NEWS CLICK: ${it.title}"
                            )
                        })
                } else {
                    NewsItemComposable(
                        news = news!!,
                        onItemClick = {
                            Log.d(
                                Constants.TAG,
                                "VideosScreenComposable: ON NEWS CLICK: ${it.title}"
                            )
                        })
                }
            }

            when (latestNewsList.loadState.append) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item { LoadingListItem() }
                }
                is LoadState.Error -> {
                    item {
                        ErrorListItem(onClick = {
                            
                        })
                    }
                }
            }

        }

        latestNewsList.loadState.apply {

            when {
                refresh is LoadState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(modifier = Modifier.size(40.dp))
                    }
                }
                append is LoadState.Loading -> {

                }
                prepend is LoadState.Loading -> {

                }
            }
        }

    }

}
