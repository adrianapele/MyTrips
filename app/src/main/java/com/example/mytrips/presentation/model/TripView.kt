package com.example.mytrips.presentation.model

import com.example.mytrips.domain.model.Trip

data class TripView(
    val trip: Trip,
    val type: TripViewType
)
