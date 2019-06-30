package net.pside.android.example.petbook.ui.shiba

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.pside.android.example.petbook.data.getDogService

class ShibaPresenter(
    private val view: ShibaContract.View
) : ShibaContract.Presenter {
    override suspend fun start() {
        val dogs = getDogService().getBleed(bleed = "shiba", limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
