package com.bhk.aac.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bhk.aac.mvvmnewsapp.R
import com.bhk.aac.mvvmnewsapp.databinding.ActivityNewsBinding
import com.bhk.aac.mvvmnewsapp.db.ArticleDatabase
import com.bhk.aac.mvvmnewsapp.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        // connect the bottom nav view with the navigation component
        // binding.bottomNavigationView.setupWithNavController(binding.newsNavHostFragment.findNavController())

        // When used with FragmentContainerView instead of fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }
}