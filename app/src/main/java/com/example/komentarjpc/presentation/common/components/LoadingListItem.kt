package com.example.komentarjpc.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.komentarjpc.presentation.common.components.ErrorListItem
import com.example.komentarjpc.ui.theme.KomentarJPCTheme

@Composable
fun LoadingListItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth(),
                color = Color.LightGray
            ) {}
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center),
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KomentarJPCTheme {
        LoadingListItem()
    }
}