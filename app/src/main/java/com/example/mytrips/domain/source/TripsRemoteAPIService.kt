package com.example.mytrips.domain.source

import com.example.mytrips.data.model.ResponseDto
import com.example.mytrips.di.Constants.Companion.TRIPS_PATH
import retrofit2.Call
import retrofit2.http.GET

interface TripsRemoteAPIService {

    @GET(TRIPS_PATH)
    fun getTrips(): Call<ResponseDto>
}