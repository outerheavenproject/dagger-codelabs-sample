package com.github.outerheavenproject.wanstagram.ui.shiba

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ShibaFragmentModule {
    @ContributesAndroidInjector
    fun contributeShibaFragment(): ShibaFragment
}
