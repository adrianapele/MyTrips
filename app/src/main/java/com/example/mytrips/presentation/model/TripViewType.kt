package com.example.mytrips.presentation.model

sealed class TripViewType

object TripHeader: TripViewType()
object TripHeaderDetails: TripViewType()