package net.pside.android.example.petbook.ui

import net.pside.android.example.petbook.data.Dog

interface MainContract {
    interface View {
        fun updateDog(dog: Dog)
    }

    interface Presenter
}
