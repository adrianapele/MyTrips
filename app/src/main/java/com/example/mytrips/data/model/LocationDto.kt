package com.example.mytrips.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep
data class LocationDto(
    @Json(name = "start") val startAddressDto: AddressDto,
    @Json(name = "end") val endAddressDto: AddressDto
)
