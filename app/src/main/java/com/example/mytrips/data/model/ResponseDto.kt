package com.example.mytrips.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDto(
    val trips: List<TripDto>
)