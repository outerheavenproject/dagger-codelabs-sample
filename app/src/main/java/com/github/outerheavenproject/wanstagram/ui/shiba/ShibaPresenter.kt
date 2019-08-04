package com.github.outerheavenproject.wanstagram.ui.shiba

import com.github.outerheavenproject.wanstagram.data.DogService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ShibaPresenter @Inject constructor(
    private val dogService: DogService
) : ShibaContract.Presenter {
    private lateinit var view: ShibaContract.View

    fun attachView(view: ShibaContract.View) {
        this.view = view
    }

    override suspend fun start() {
        val dogs = dogService.getBleed(bleed = "shiba", limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
