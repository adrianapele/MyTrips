package com.example.mytrips.data.repository

import com.example.mytrips.domain.model.Trip
import com.example.mytrips.domain.source.TripsRemoteDataSource
import javax.inject.Inject

class TripsRepository @Inject constructor(
    private val remoteDataSource: TripsRemoteDataSource
) {

    fun getTrips(): List<Trip>? {
        return remoteDataSource.getRemoteTrips()
    }
}