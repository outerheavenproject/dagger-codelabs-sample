package net.pside.android.example.petbook.data

import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    suspend fun getDog(): Dog
}
