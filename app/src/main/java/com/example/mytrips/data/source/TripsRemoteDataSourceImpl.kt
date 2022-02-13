package com.example.mytrips.data.source

import com.example.mytrips.data.mapper.TripMapper
import com.example.mytrips.domain.model.Trip
import com.example.mytrips.domain.source.TripsRemoteAPIService
import com.example.mytrips.domain.source.TripsRemoteDataSource

class TripsRemoteDataSourceImpl(
    private val remoteAPIService: TripsRemoteAPIService,
    private val mapper: TripMapper
): TripsRemoteDataSource {

    override fun getRemoteTrips(): List<Trip>? {
        val response = remoteAPIService.getTrips().execute()
        return if (response.isSuccessful) {
            response.body()?.map { mapper.mapDtoToModel(it)}
        } else null
    }
}