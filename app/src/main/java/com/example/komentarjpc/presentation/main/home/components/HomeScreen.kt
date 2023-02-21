@file:OptIn(ExperimentalPagerApi::class)

package com.example.komentarjpc.presentation.main.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.komentarjpc.domain.model.Category
import com.example.komentarjpc.presentation.main.home.viewmodel.HomeViewModel
import com.example.komentarjpc.ui.theme.LightBlue
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {

        if (state.categories.isNotEmpty()) {
            MainContent(state.categories)
        }

    }

}

@Composable
fun CategoryNewsListScreen(category: Category) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category.name)
    }

}

@Composable
fun MainContent(categories: List<Category>) {

    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {

        Tabs(categories = categories, pagerState = pagerState)

        HorizontalPager(count = categories.size, state = pagerState) {
            CategoryNewsListScreen(category = categories.get(pagerState.currentPage))
        }

    }
}

@Composable
fun Tabs(
    categories: List<Category>,
    pagerState: PagerState
) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = LightBlue,
        edgePadding = 24.dp,
    ) {

        categories.forEachIndexed { index, category ->

            Tab(selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }) {
                Text(
                    text = category.name.uppercase(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White,
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

}
