package com.example.stcpaychallenge.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe


fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner) { data -> data?.let { block(it) } }
}