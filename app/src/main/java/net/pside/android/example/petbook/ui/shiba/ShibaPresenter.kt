package net.pside.android.example.petbook.ui.shiba

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.pside.android.example.petbook.data.getDogService
import net.pside.android.example.petbook.ui.MainContract

class ShibaPresenter(
    private val view: MainContract.View
) : MainContract.Presenter {
    suspend fun start() {
        val dogs = getDogService().getBleed(bleed = "shiba", limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
