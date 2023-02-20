package com.example.komentarjpc.presentation.main.components.bottom_navigation_bar

import com.example.komentarjpc.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home,
    )
    object Latest: BottomBarScreen(
        route = "latest",
        title = "Latest",
        icon = R.drawable.ic_latest,
    )
    object Video: BottomBarScreen(
        route = "video",
        title = "Video",
        icon = R.drawable.ic_video,
    )
    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search,
    )
}
