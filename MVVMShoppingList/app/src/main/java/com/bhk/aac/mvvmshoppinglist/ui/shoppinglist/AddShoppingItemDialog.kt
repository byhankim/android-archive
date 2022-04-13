package com.bhk.aac.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.bhk.aac.mvvmshoppinglist.R
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.bhk.aac.mvvmshoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogAddShoppingItemBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        binding.addTv.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val amount = binding.amountEt.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the info", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.cancelTv.setOnClickListener {
            cancel()
        }


    }

}