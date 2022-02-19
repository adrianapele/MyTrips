package com.example.mytrips.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytrips.domain.interactors.GetTripsUseCase
import com.example.mytrips.domain.model.Trip
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@HiltViewModel
open class TripsListingViewModel @Inject constructor(
    private val getTripsUseCase: GetTripsUseCase,
): ViewModel() {

    val tripsLiveData = MutableLiveData<List<Trip>>()

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
                tripsLiveData.value = t
            }

            override fun onError(e: Throwable) {
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        getTripsUseCase.dispose()
    }
}