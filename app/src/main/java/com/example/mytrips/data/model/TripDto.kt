package com.example.mytrips.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep
data class TripDto(
    val id: String,
    @Json(name = "start") val startTime: String,
    @Json(name = "end") val endTime: String,
    @Json(name = "location") val locationDto: LocationDto,
    val image: String
)
