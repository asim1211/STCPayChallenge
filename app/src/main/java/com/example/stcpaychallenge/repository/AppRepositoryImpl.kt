package com.example.stcpaychallenge.repository

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


internal class AppRepositoryImpl @Inject constructor(private val appApi: AppApi) : AppRepository {
    override fun searchJobs(searchQuery: String?) = appApi.searchJobs(searchQuery)
        .subscribeOn(Schedulers.io())
        .onErrorReturn { emptyList() }
}
