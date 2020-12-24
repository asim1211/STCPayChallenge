package com.example.stcpaychallenge.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel(protected val compositeDisposable: CompositeDisposable) : ViewModel() {

    public override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}