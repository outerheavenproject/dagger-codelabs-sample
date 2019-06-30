package net.pside.android.example.petbook.ui.shiba

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import net.pside.android.example.petbook.data.DogService
import net.pside.android.example.petbook.ui.MainContract
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

class ShibaPresenter(
    private val view: MainContract.View
) : MainContract.Presenter {
    suspend fun start() {
        val dogs = getDogService().getBleed(bleed = "shiba", limit = 20)
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}

private fun getDogService(): DogService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType())
        )
        .build()
    return retrofit.create()
}
