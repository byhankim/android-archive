package com.bhk.aac.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// annotation to address this data class is an Entity
// For SQL there must be a PK
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int // column in db
) {
    @PrimaryKey(autoGenerate = true) // Room will automatically do this for us
    var id: Int? = null
}
