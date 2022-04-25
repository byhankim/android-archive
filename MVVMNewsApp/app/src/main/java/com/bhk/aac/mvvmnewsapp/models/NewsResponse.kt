package com.bhk.aac.mvvmnewsapp.models

import com.bhk.aac.mvvmnewsapp.models.Article

data class NewsResponse(
    val status: String = "", // ok
    val totalResults: Int = 0, // 367
    val articles: List<Article> = listOf()
)
