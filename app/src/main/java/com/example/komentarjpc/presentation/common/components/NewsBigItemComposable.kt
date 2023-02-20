package com.example.komentarjpc.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberImagePainter
import com.example.komentarjpc.domain.model.News
import com.example.komentarjpc.util.convertToTime


@Composable
fun NewsBigItemComposable(
    news: News,
    onItemClick: (News) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(news) }

    ) {

        val painter = rememberImagePainter(
            data = news.image,
        )

        Image(
            painter = painter,
            contentDescription = "News Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )


        Text(
            text = news.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            ),
            maxLines = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 5.dp,
                    start = 10.dp,
                    end = 10.dp,
                )
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                    bottom = 5.dp
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

}