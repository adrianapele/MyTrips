package com.example.mytrips.data.model

import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TripDto(
    val id: String,
    val startTime: String,
    val endTime: String,
    val locationDto: LocationDto,
    val image: String
)
