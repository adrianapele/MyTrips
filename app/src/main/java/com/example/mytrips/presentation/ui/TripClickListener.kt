package com.example.mytrips.presentation.ui

import com.example.mytrips.presentation.model.TripView

interface TripClickListener {

    fun onTripClicked(tripView: TripView)
}