package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.AppNavigatorImpl
import com.github.outerheavenproject.wanstagram.ui.MainActivity
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubcomponent {
    fun inject(activity: MainActivity): MainActivity
    fun inject(fragment: DogFragment): DogFragment
    fun inject(fragment: ShibaFragment): ShibaFragment

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivitySubcomponent
    }
}

@Module
interface MainActivityModule {
    @Binds
    fun bindAppNavigator(navigator: AppNavigatorImpl): AppNavigator
}
