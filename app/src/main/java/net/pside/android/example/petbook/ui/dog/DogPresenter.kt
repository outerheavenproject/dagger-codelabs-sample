package net.pside.android.example.petbook.ui.dog

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.pside.android.example.petbook.data.getDogService

class DogPresenter(
    private val view: DogContract.View
) : DogContract.Presenter {
    override suspend fun start() {
        val dogs = getDogService().getDogs(limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
