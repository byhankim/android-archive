package com.bhk.aac.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.bhk.aac.mvvmnewsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
): ViewModel() {

}