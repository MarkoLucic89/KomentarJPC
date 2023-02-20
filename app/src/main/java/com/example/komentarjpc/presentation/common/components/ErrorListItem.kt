package com.example.komentarjpc.presentation.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.komentarjpc.R
import com.example.komentarjpc.ui.theme.DarkBlue
import com.example.komentarjpc.ui.theme.KomentarJPCTheme

@Composable
fun ErrorListItem(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                        .clickable {
                            onClick
                        },
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_refresh),
                    contentDescription = "Some icon",
                    tint = DarkBlue
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KomentarJPCTheme {
        ErrorListItem {

        }
    }
}