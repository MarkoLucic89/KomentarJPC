package com.example.komentarjpc.presentation.main.components.bottom_navigation_bar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.komentarjpc.presentation.main.home.components.HomeScreen
import com.example.komentarjpc.presentation.main.latest.components.LatestScreen
import com.example.komentarcompose.presentation.main.search.components.SearchScreen
import com.example.komentarjpc.presentation.main.videos.components.VideosScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        builder = {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarScreen.Latest.route) {
                LatestScreen()
            }
            composable(route = BottomBarScreen.Video.route) {
                VideosScreen()
            }
            composable(route = BottomBarScreen.Search.route) {
                SearchScreen()
            }
        }
    )
}