package com.bhk.aac.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bhk.aac.mvvmnewsapp.models.Article

@Dao // Room will know that the interface is defining functions for db io
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>// will return livedata, so no need for suspend function(io)
    // livedata: observers to subscribe the changes in the list

    @Delete
    suspend fun deleteArticle(article: Article)

}