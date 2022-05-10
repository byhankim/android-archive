package com.bhk.aac.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.bhk.aac.mvvmnewsapp.models.Article

// DB class for Room MUST be an abstract class

@Database(
    entities = [Article::class],
    version = 1,
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        // instance of db

        @Volatile // other threads  can check when a thread changes this instance
        private var instance: ArticleDatabase? = null
        private val LOCK = Any() // synchronize the instance

        // executed whenever the obj is instantiated
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // synchronized => other threads can't touch this
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()

    }

}