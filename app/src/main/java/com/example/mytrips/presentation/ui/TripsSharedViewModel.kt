package com.example.mytrips.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytrips.domain.interactors.GetTripsUseCase
import com.example.mytrips.domain.model.Trip
import com.example.mytrips.presentation.model.TripView
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@HiltViewModel
open class TripsSharedViewModel @Inject constructor(
    private val getTripsUseCase: GetTripsUseCase,
): ViewModel() {

    var loadedTrips: List<Trip>? = null
    val tripsViewLiveData = MutableLiveData<List<TripView>>()

    init {
        loadTrips()
    }

    private fun loadTrips() {
        getTripsUseCase.execute(createSubscriber())
    }

    private fun createSubscriber(): DisposableObserver<List<Trip>?> {
        return object : DisposableObserver<List<Trip>?>() {

            override fun onComplete() {
            }

            override fun onNext(t: List<Trip>) {
                loadedTrips = t
                tripsViewLiveData.value = t
                    .groupBy { it.startDate }
                    .entries
                    .map { TripView(it.key, it.value) }
            }

            override fun onError(e: Throwable) {
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        getTripsUseCase.dispose()
    }

    fun getTripById(tripId: String): Trip? {
        return loadedTrips?.find { it.id == tripId }
    }
}