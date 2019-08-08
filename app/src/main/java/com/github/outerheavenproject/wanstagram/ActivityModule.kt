package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.ui.MainActivityModule
import dagger.Module

@Module(
    includes = [
        MainActivityModule::class
    ]
)
interface ActivityModule
