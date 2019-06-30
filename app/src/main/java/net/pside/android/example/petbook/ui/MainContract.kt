package net.pside.android.example.petbook.ui

import net.pside.android.example.petbook.data.Dogs

interface MainContract {
    interface View {
        fun updateDogs(dogs: Dogs)
    }

    interface Presenter
}
