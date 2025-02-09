package com.example.employeedirectory.presentation.model

sealed class Result<out R> {
    class Success<out T>(val data: T) : Result<T>()
    class Error(val message: String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}