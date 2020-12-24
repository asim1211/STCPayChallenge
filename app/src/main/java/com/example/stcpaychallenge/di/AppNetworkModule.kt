package com.example.stcpaychallenge.di

import com.example.stcpaychallenge.di.qualifiers.Animals
import com.example.stcpaychallenge.repository.AppApi
import com.example.stcpaychallenge.repository.AppRepository
import com.example.stcpaychallenge.repository.AppRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppNetworkModule {

    @Singleton
    @Provides
    fun provideAppRepository(jobsApi: AppApi): AppRepository {
        return AppRepositoryImpl(jobsApi)
    }

    @Singleton
    @Provides
    @Animals
    fun providesClient(): OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .retryOnConnectionFailure(false)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)

    @Singleton
    @Provides
    fun provideAppApi(
        @Animals clientBuilder: OkHttpClient.Builder
    ): AppApi = Retrofit.Builder()
        .baseUrl("https://jobs.github.com")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(clientBuilder.build())
        .build().create(AppApi::class.java)

}