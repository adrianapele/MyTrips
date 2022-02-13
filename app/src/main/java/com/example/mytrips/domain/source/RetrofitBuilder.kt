package com.example.mytrips.domain.source

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://autoliv.github.io/"

class RetrofitBuilder(
    private val moshiConverterFactory: MoshiConverterFactory,
    private val rxJavaCallAdapter: CallAdapter.Factory
) {

    fun make(): Retrofit.Builder {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapter)
            .baseUrl(BASE_URL)
    }
}