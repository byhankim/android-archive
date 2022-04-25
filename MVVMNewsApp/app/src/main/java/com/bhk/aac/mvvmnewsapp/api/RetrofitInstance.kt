package com.bhk.aac.mvvmnewsapp.api

import com.bhk.aac.mvvmnewsapp.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy { //only init once

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY) // see response body
            val client = OkHttpClient.Builder() // okhttp network client
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        // api instance from retrofit builder (for network requests)
        val api by lazy {
            retrofit.create(NewsAPI::class.java) // class of our api interface
        }
    }
}