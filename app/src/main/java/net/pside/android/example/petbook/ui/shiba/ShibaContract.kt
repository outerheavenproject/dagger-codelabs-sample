package net.pside.android.example.petbook.ui.shiba

import net.pside.android.example.petbook.data.Dogs

interface ShibaContract {
    interface View {
        fun updateDogs(dogs: Dogs)
    }

    interface Presenter
}
