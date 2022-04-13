package com.bhk.aac.mvvmshoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhk.aac.mvvmshoppinglist.R
import com.bhk.aac.mvvmshoppinglist.data.db.ShoppingDatabase
import com.bhk.aac.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.bhk.aac.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.bhk.aac.mvvmshoppinglist.databinding.ActivityShoppingBinding
import com.bhk.aac.mvvmshoppinglist.other.ShoppingItemAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    private lateinit var binding: ActivityShoppingBinding
    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        /**
         * BAD PRACTICE!! => Dependant on ShoppingActivity!!
         * when this activity changes, must re instantiate these
         * therefore it's better ins them in a global place & pass them from there
         */
//        val database = ShoppingDatabase(this)
//        val repository = ShoppingRepository(database)
//        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        binding.shoppingItemsRv.layoutManager = LinearLayoutManager(this)
        binding.shoppingItemsRv.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this,
            object: AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}