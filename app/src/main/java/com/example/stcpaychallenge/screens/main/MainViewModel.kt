package com.example.stcpaychallenge.screens.main

import com.example.stcpaychallenge.base.BaseViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable

internal class MainViewModel @AssistedInject constructor(compositeDisposable: CompositeDisposable, @Assisted val currency: String) : BaseViewModel(
    compositeDisposable
){

    @AssistedInject.Factory
    interface Factory {
        fun create(currency: String): MainViewModel
    }

}