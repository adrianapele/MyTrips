package com.example.mytrips.domain.source

import com.example.mytrips.domain.model.Trip

interface TripsRemoteDataSource {

    fun getRemoteTrips(): List<Trip>?
}