package com.example.mytrips.data.repository

import com.example.mytrips.domain.model.Trip
import com.example.mytrips.domain.source.TripsRemoteDataSource

class TripsRepository(
    private val remoteDataSource: TripsRemoteDataSource
) {

    fun getTrips(): List<Trip> {
        return remoteDataSource.getRemoteTrips() ?: emptyList()
    }
}