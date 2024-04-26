package com.rawringlory.aironment.features.util

sealed class DataWrapper<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?): DataWrapper<T>(data)
    class Error<T>(message: String, data: T? = null): DataWrapper<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true): DataWrapper<T>(null)
}