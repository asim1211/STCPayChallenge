package com.example.stcpaychallenge.repository

import com.example.stcpaychallenge.model.Job
import io.reactivex.Single

interface AppRepository {

    fun searchJobs(searchQuery: String?): Single<List<Job>>
}