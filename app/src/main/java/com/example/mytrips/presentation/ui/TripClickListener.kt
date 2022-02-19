package com.example.mytrips.presentation.ui

import com.example.mytrips.domain.model.Trip

interface TripClickListener {

    fun onTripClicked(trip: Trip)
}