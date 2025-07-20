package com.ecomexpress.customerpanel.utils

sealed class Resource<out T : Any> {
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val errorMessage: String) : Resource<Nothing>()
    data class Exception(val description: String) : Resource<Nothing>()
    data class Message(val description: String) : Resource<Nothing>()
    object Empty : Resource<Nothing>()
}

