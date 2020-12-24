package com.example.stcpaychallenge.screens.detailsScreen

import com.example.stcpaychallenge.base.BaseViewModel
import com.example.stcpaychallenge.repository.AppRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable

class DetailsScreenViewModel @AssistedInject constructor(
    private val appRepository: AppRepository,
    compositeDisposable: CompositeDisposable,
    @Assisted val config: String
) : BaseViewModel(compositeDisposable) {

    @AssistedInject.Factory
    interface Factory {
        fun create(config: String): DetailsScreenViewModel
    }

}