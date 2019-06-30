package net.pside.android.example.petbook.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("message") val message: String,
    @SerialName("status") val status: String
)
