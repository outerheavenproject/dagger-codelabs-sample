package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun contributeDogFragment(): DogFragment
}
