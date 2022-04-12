package com.bhk.aac.mvvmshoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // if already in DB, replace it
    suspend fun upsert(item: ShoppingItem) // update  &  insert

    @Delete
    suspend fun delete(item: ShoppingItem) // suspend: keyword for coroutine functions

    @Query("SELECT * FROM shopping_items")
    suspend fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}