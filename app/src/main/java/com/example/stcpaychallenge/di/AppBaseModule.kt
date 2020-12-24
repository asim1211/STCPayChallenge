package com.example.stcpaychallenge.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class AppBaseModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}