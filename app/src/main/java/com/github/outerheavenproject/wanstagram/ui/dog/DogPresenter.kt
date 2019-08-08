package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogPresenter @Inject constructor(
    private val repository: DogRepository
) : DogContract.Presenter {
    private lateinit var view: DogContract.View

    fun attachView(view: DogContract.View) {
        this.view = view
    }

    override suspend fun start() {
        val dogs = repository.findAll()
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
