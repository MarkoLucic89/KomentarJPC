package com.example.komentarjpc.util

fun convertToTime(createdAt: String): String = createdAt.substring(11, 16).uppercase()