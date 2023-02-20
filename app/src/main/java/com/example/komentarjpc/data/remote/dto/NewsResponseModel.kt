package com.example.komentarjpc.data.remote.dto

data class NewsResponseModel(val name: String) : BaseResponseModel() {

    lateinit var data: NewsDataResponseModel

    class NewsDataResponseModel {
        lateinit var pagination: NewsPaginationResponseModel
        lateinit var news: List<NewsDto>
    }

    class NewsPaginationResponseModel {
        var total = 0
        var count = 0
        var current_page = 0
        var has_more_pages = false
        var last_page = 0
        var per_page = 0
    }


}
