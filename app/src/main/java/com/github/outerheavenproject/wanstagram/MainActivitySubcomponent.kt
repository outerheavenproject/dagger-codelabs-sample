package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface MainActivitySubcomponent {
    fun inject(mainActivity: MainActivity): MainActivity

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivitySubcomponent
    }
}
