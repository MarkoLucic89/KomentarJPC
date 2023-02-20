package com.example.komentarjpc.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.komentarjpc.presentation.main.components.bottom_navigation_bar.BottomBar
import com.example.komentarjpc.presentation.main.components.bottom_navigation_bar.BottomNavGraph

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            BottomNavGraph(navController = navController)
        }
    }
}


