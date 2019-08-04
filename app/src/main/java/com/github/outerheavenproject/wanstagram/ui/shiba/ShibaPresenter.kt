package com.github.outerheavenproject.wanstagram.ui.shiba

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.github.outerheavenproject.wanstagram.data.getDogService

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
