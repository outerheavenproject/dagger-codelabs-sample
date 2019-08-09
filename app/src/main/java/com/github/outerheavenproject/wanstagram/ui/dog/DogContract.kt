package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.Dogs

interface DogContract {
    interface View {
        fun updateDogs(dogs: Dogs)
    }

    interface Presenter {
        fun attachView(view: View)
        suspend fun start()
    }
}
