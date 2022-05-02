package com.bhk.aac.mvvmnewsapp.utils

// sealed class: can define which classes are allowed to inherit this
sealed class Resource<T>(
    val data: T? = null, // body of response
    val message: String? = null // message of response
) {
    // only these 3 classes are allowed to inherit from resource
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>: Resource<T>()
}