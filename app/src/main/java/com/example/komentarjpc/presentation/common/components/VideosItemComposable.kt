package com.example.komentarjpc.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberImagePainter
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.ui.theme.DarkBlue
import com.example.komentarjpc.util.convertToTime
import com.example.komentarjpc.R


@Composable
fun VideosItemComposable(
    news: News,
    onItemClick: (News) -> Unit
) {

    Box(
        modifier = Modifier
            .background(DarkBlue)
            .fillMaxWidth()
            .height(260.dp)
            .padding(10.dp)
            .clickable { onItemClick(news) }

    ) {

        val painter = rememberImagePainter(
            data = news.image,
        )

        Image(
            painter = painter,
            contentDescription = "News Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 200f
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Text(
                text = news.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 3,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .padding(
                        top = 10.dp
                    )
            ) {

                Text(
                    text = news.categoryTitle.uppercase(),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(news.categoryColor.toColorInt()),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    ),
                )

                Text(
                    text = " | ${convertToTime(news.createdAt)}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    ),
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_play_video),
            contentDescription = "Play Video",
            modifier = Modifier
                .alpha(0.5f)
                .align(Alignment.Center)
                .width(50.dp)
                .height(50.dp),
            tint = Color.White
        )

    }

}