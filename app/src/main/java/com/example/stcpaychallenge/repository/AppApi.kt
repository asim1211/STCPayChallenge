package com.example.stcpaychallenge.repository

import com.example.stcpaychallenge.model.Job
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    @GET("/positions.json")
    fun searchJobs(
        @Query("search") search: String?
    ): Single<List<Job>>

}