package net.pside.android.example.petbook.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("breeds/image/random")
    suspend fun getDog(): Dog

    @GET("breeds/image/random/{limit}")
    suspend fun getDogs(@Path("limit") limit: Int): Dogs

    @GET("breed/{bleed}/images/random/{limit}")
    suspend fun getBleed(
        @Path("bleed") bleed: String,
        @Path("limit") limit: Int
    ): Dogs
}

fun getDogService(): DogService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType())
        )
        .build()
    return retrofit.create()
}
