package com.bhk.aac.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhk.aac.mvvmnewsapp.R
import com.bhk.aac.mvvmnewsapp.adapters.NewsAdapter
import com.bhk.aac.mvvmnewsapp.databinding.FragmentBreakingNewsBinding
import com.bhk.aac.mvvmnewsapp.ui.NewsActivity
import com.bhk.aac.mvvmnewsapp.ui.NewsViewModel
import com.bhk.aac.mvvmnewsapp.utils.Resource

class BreakingNewsFragment: Fragment() {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private var _binding: FragmentBreakingNewsBinding? = null
    val binding get() = _binding!!

    val TAG = "BreakingNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        // use vm to call breaking news livedata & observe on that
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    Log.e(TAG, "# SUCCESS #")
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    Log.e(TAG, "# ERROR #")
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred! $message")
                    }
                }
                is Resource.Loading -> {
                    Log.e(TAG, "# LOADING #")
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}