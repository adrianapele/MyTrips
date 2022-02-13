package com.example.mytrips.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddressDto(
    val city: String,
    val county: String,
    val country: String
)
