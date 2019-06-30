package net.pside.android.example.petbook.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.pside.android.example.petbook.data.getDogService

class MainPresenter(
    private val view: MainContract.View
) : MainContract.Presenter {
    suspend fun start() {
        val dogs = getDogService().getDogs(limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
