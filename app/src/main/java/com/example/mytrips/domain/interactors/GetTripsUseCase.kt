package com.example.mytrips.domain.interactors

import com.example.mytrips.data.repository.TripsRepository
import com.example.mytrips.domain.model.Trip
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetTripsUseCase @Inject constructor(
    private val tripsRepository: TripsRepository
) {

    private val compositeDisposable = CompositeDisposable()

    fun execute(subscriber: DisposableObserver<List<Trip>?>) {
        val observable = Observable
            .fromCallable {
                try {
                    tripsRepository.getTrips()
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        compositeDisposable.addAll(observable.subscribeWith(subscriber))
    }

    fun dispose() {
        compositeDisposable.dispose()
    }
}