package com.bhk.aac.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhk.aac.mvvmshoppinglist.R
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.bhk.aac.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel // needs to call the del function from vm
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.nameTv).text = currentShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.amountTv).text = "${currentShoppingItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.deleteIv).setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.PlusIv).setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.minusIv).setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
            }
            viewModel.upsert(currentShoppingItem)
        }

    }

    override fun getItemCount() = items.size
}