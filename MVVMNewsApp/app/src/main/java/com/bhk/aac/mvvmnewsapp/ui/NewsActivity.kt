package com.bhk.aac.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bhk.aac.mvvmnewsapp.R
import com.bhk.aac.mvvmnewsapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        // connect the bottom nav view with the navigation component
        binding.bottomNavigationView.setupWithNavController(binding.newsNavHostFragment.findNavController())


    }
}