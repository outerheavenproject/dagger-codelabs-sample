package com.github.outerheavenproject.wanstagram.ui.dog

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.github.outerheavenproject.wanstagram.data.getDogService

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
