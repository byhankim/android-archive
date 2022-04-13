package com.bhk.aac.mvvmshoppinglist.ui.shoppinglist

import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}