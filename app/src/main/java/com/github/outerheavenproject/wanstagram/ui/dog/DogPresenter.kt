package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.DogService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogPresenter @Inject constructor(
    private val dogService: DogService
) : DogContract.Presenter {
    private lateinit var view: DogContract.View

    fun attachView(view: DogContract.View) {
        this.view = view
    }

    override suspend fun start() {
        val dogs = dogService.getDogs(limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
