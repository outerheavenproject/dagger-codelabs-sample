package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragmentModule
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityBindModule::class,
            DogFragmentModule::class,
            ShibaFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindContext(context: MainActivity): Context

    @Binds
    fun bindAppNavigator(navigator: AppNavigatorImpl): AppNavigator
}
