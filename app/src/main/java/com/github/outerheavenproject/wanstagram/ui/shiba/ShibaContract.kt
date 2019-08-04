package com.github.outerheavenproject.wanstagram.ui.shiba

import com.github.outerheavenproject.wanstagram.data.Dogs

interface ShibaContract {
    interface View {
        fun updateDogs(dogs: Dogs)
    }

    interface Presenter {
        suspend fun start()
    }
}
