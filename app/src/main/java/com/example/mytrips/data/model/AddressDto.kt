package com.example.mytrips.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep
data class AddressDto(
    val city: String,
    val county: String,
    val country: String
)
