package com.bhk.aac.mvvmshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhk.aac.mvvmshoppinglist.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }


    }
}