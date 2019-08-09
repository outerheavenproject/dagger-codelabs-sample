package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            DogFragmentBindModule::class
        ]
    )
    fun contributeDogFragment(): DogFragment
}

@Module
interface DogFragmentBindModule {
    @Binds
    fun bindAppNavigator(navigator: AppNavigatorImpl): AppNavigator
}
