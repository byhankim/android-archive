package com.bhk.aac.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.bhk.aac.mvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * CREATE THE INSTANCE OF THIS VM TO SHOPPING ACTIVITY
 */
class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel()  {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item )
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    // no need for coroutine 'cause it's read only
    fun getAllShoppingItems() = repository.getAllShoppingData()
 }