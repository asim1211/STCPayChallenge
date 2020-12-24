package com.example.stcpaychallenge.di

import android.content.Context
import com.example.stcpaychallenge.screens.detailsScreen.DetailsScreenViewModel
import com.example.stcpaychallenge.screens.listScreen.ListScreenViewModel
import com.example.stcpaychallenge.screens.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AssistedInjectModule::class, AppNetworkModule::class, AppBaseModule::class])
internal interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    val appMainViewModel: MainViewModel.Factory
    val appListViewModel: ListScreenViewModel.Factory
    val appDetailsViewModel: DetailsScreenViewModel.Factory
}