package net.pside.android.example.petbook.data

import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("breeds/image/random")
    suspend fun getDog(): Dog

    @GET("breeds/image/random/{limit}")
    suspend fun getDogs(@Path("limit") limit: Int): Dogs
}
