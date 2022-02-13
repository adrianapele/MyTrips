package com.example.mytrips.domain.model

data class Trip(
    val id: String,
    val startTime: String,
    val endTime: String,
    val location: Location,
    val image: String
)
