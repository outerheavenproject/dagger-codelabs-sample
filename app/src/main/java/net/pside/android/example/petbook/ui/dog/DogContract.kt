package net.pside.android.example.petbook.ui.dog

import net.pside.android.example.petbook.data.Dogs

interface DogContract {
    interface View {
        fun updateDogs(dogs: Dogs)
    }

    interface Presenter {
        suspend fun start()
    }
}
