package net.pside.android.example.petbook.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("message") val url: String,
    @SerialName("status") val status: String
)

@Serializable
data class Dogs(
    @SerialName("message") val urls: List<String>,
    @SerialName("status") val status: String
)
