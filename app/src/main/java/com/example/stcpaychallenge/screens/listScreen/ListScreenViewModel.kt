package com.example.stcpaychallenge.screens.listScreen

import androidx.lifecycle.MutableLiveData
import com.example.stcpaychallenge.base.BaseViewModel
import com.example.stcpaychallenge.model.Job
import com.example.stcpaychallenge.model.Results
import com.example.stcpaychallenge.repository.AppRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

internal class ListScreenViewModel @AssistedInject constructor(
    private val appRepository: AppRepository,
    compositeDisposable: CompositeDisposable,
    @Assisted val query: String
) : BaseViewModel(compositeDisposable) {

    @AssistedInject.Factory
    interface Factory {
        fun create(query: String): ListScreenViewModel
    }

    private val _viewData: MutableLiveData<Results<List<Job>>> = MutableLiveData()
    val viewData: MutableLiveData<Results<List<Job>>>
        get() = _viewData

    init {
        getJobs()
    }

    fun getJobs(query: String? = "") {
        compositeDisposable += appRepository.searchJobs(query)
            .subscribeOn(Schedulers.io())
            .onErrorReturn { emptyList() }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { _viewData.postValue(Results.Error(it)) }
            .subscribeBy { _viewData.postValue(Results.Success(it)) }
    }
}