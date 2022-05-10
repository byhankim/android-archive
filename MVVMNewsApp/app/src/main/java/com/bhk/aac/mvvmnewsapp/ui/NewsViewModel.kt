package com.bhk.aac.mvvmnewsapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhk.aac.mvvmnewsapp.models.NewsResponse
import com.bhk.aac.mvvmnewsapp.repository.NewsRepository
import com.bhk.aac.mvvmnewsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

    init {
        getBreakingNews("us")
    }

    val TAG = "NewsViewModel"

    // create a livedata
    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val breakingNewsPage = 1 // for pagination

    // execute the api code from the repository
    fun getBreakingNews(countryCode: String) =
        viewModelScope.launch { // vmScope: stays alive as long as vm is alive
            // b4 actual network call, emit the loading state of livedata?

            breakingNews.postValue(Resource.Loading())
            val response = newsRepository.getBreakingNews(
                countryCode,
                breakingNewsPage
            ) // coroutine w8s to be done

            // calls livedata
            breakingNews.postValue(handleBreakingNewsResponse(response))
        }

    // decides whether to return success / error response
    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}