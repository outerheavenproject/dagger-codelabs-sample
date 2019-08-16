package com.github.outerheavenproject.wanstagram.ui.shiba

import com.github.outerheavenproject.wanstagram.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ShibaFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun contributeShibaFragment(): ShibaFragment
}
