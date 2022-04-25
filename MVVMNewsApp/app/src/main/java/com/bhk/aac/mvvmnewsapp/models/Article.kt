package com.bhk.aac.mvvmnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey


// to save in DB, need to annotate this class with Entity

@Entity(tableName="articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val source: Source = Source(),
    val author: String? = null, // Adam Willems
    val title: String = "", // Crypto Is Poised to Reshape Taxes—and Cities
    val description: String = "",
    val url: String = "",
    val urlToImage: String? = null,
    val publishedAt: String = "",
    val content: String = ""
)
