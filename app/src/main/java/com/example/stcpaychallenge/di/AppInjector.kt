package com.example.stcpaychallenge.di

import android.app.Application

internal object AppInjector {

    var appComponent: AppComponent? = null
        private set

    fun createVendorsComponent(
        appContext: Application
    ) {
        if (appComponent != null) return
        appComponent = DaggerAppComponent.factory().create(
            appContext
        )
    }

    fun clearAppComponent() {
        appComponent = null
    }
}

internal val appComponent get() = AppInjector.appComponent