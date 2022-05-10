package com.bhk.aac.mvvmnewsapp.repository

import com.bhk.aac.mvvmnewsapp.api.RetrofitInstance
import com.bhk.aac.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase // for inner db
) {
    // function to get Breaking News API
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}