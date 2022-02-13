package com.example.mytrips.domain.source

import com.example.mytrips.data.model.TripDto
import retrofit2.Call
import retrofit2.http.GET

const val PATH = "interview-data.json"

interface TripsRemoteAPIService {

    @GET(PATH)
    fun getTrips(): Call<List<TripDto>>
}