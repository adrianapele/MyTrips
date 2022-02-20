package com.example.mytrips.di

import com.example.mytrips.data.source.TripsRemoteDataSourceImpl
import com.example.mytrips.domain.source.TripsRemoteAPIService
import com.example.mytrips.domain.source.TripsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideTripsApiService(retrofit: Retrofit): TripsRemoteAPIService = retrofit
        .create(TripsRemoteAPIService::class.java)

    @Singleton
    @Provides
    fun provideTripsDataSource(tripsRemoteDataSourceImpl: TripsRemoteDataSourceImpl): TripsRemoteDataSource =
        tripsRemoteDataSourceImpl

}