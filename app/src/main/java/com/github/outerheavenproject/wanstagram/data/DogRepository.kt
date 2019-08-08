package com.github.outerheavenproject.wanstagram.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRepository @Inject constructor(
    private val dogService: DogService
) {
    companion object {
        private const val LIMIT = 20
    }

    private var dogs: Dogs? = null

    suspend fun findAll(): Dogs {
        dogs?.let { return it }
        return dogService.getDogs(LIMIT)
            .also { dogs = it }
    }
}
