package com.example.stcpaychallenge.model

sealed class Results<T>(open val data: T? = null) {
    class Data<T>(override val data: T) : Results<T>(data)
    class Success<T>(override val data: T) : Results<T>(data)
    class Loading<T>(data: T? = null) : Results<T>(data)
    class Error<T>(val error: Throwable, data: T? = null) : Results<T>(data)
}