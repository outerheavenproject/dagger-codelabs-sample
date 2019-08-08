package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
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

    fun inject(fragment: DogFragment): DogFragment
    fun inject(fragment: ShibaFragment): ShibaFragment
}
