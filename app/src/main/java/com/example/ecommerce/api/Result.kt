package com.example.ecommerce.api

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val errorCode: Int? = null, val errorBody : String? = null) : Result<T>()
}