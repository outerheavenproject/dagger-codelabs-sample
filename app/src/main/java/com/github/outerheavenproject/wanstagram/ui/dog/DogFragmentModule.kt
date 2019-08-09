package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.di.MyScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogFragmentModule {
    @MyScope
    @ContributesAndroidInjector
    fun contributeDogFragment(): DogFragment
}
