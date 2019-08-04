package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.data.DogService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .build()

    @Singleton
    @Provides
    fun provideDogService(retrofit: Retrofit): DogService = retrofit.create()
}
