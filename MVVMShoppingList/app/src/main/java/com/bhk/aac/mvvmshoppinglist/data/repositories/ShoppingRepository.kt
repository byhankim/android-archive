package com.bhk.aac.mvvmshoppinglist.data.repositories

import com.bhk.aac.mvvmshoppinglist.data.db.ShoppingDatabase
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    // db methods to define shoppingDao object
    // for VM to call methods in Repository

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingData() = db.getShoppingDao().getAllShoppingItems()


}