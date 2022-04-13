package com.bhk.aac.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // if already in DB, replace it
    suspend fun upsert(item: ShoppingItem) // update  &  insert

    @Delete
    suspend fun delete(item: ShoppingItem) // suspend: keyword for coroutine functions

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}