package com.example.mytrips.presentation.model

import com.example.mytrips.domain.model.Trip

data class TripView(
    val tripGroupDay: String,
    val trips: List<Trip>,
) {
    fun areItemsTheSame(newItem: TripView): Boolean {
        return this.tripGroupDay == newItem.tripGroupDay
    }

    fun areContentsTheSame(newItem: TripView): Boolean {
        return this.trips == newItem.trips
    }
}
