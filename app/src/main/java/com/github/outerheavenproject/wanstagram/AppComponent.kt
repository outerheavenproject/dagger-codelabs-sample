package com.github.outerheavenproject.wanstagram

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        OkHttpClientModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun mainActivitySubcomponentFactory(): MainActivitySubcomponent.Factory
}
