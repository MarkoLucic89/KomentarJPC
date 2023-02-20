package com.example.komentarjpc.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.komentarjpc.presentation.main.components.MainScreen
import com.example.komentarjpc.presentation.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        builder = {
            composable(route = Screen.Splash.route) {
                SplashScreen()
            }
            composable(route = Screen.Main.route) {
                MainScreen()
            }
        }
    )
}