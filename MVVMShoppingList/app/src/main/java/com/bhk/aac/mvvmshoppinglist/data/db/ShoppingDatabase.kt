package com.bhk.aac.mvvmshoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem

// represents the actual DB
@Database(
    // which entities belong to our db
    entities = [ShoppingItem::class],
    version = 1,
)
abstract class ShoppingDatabase: RoomDatabase() {

    // can access DB operations from inside the DB class
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        // create instance of shopping db
        @Volatile // instance will be visible to other threads
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // executed whenever the shoppingDB class's instance is created
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,
                "shoppingDB.db").build()
    }
}