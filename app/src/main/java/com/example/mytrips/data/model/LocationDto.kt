package com.example.mytrips.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDto(
    val startAddressDto: AddressDto,
    val endAddressDto: AddressDto
)
