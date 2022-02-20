package com.example.mytrips.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.mytrips.R
import com.example.mytrips.databinding.FragmentTripDetailsBinding
import com.example.mytrips.domain.model.Trip
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripDetailsFragment: Fragment() {

    private val args: TripDetailsFragmentArgs by navArgs()
    private val viewModel: TripsSharedViewModel by activityViewModels()
    private var binding: FragmentTripDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.toolbar_trip_details)
        setObservers()
    }

    private fun setObservers() {
        viewModel.getTripById(args.tripId)?.let {
            binding?.tvStartDetails?.text = getStartText(it)
            binding?.tvEndDetails?.text = getEndText(it)
            Picasso.get().load(it.image).into(binding?.ivTripImage)
        }
    }

    private fun getStartText(trip: Trip): String {
        val startAddress = trip.location.startAddress
        val startText = "${startAddress.city}, ${startAddress.country} ${trip.startTime} ${trip.startDate}"
        return requireContext().getString(R.string.trip_details_start, startText)
    }

    private fun getEndText(trip: Trip): String {
        val endAddress = trip.location.endAddress
        val endText = "${endAddress.city}, ${endAddress.country} ${trip.endTime} ${trip.endDate}"
        return requireContext().getString(R.string.trip_details_end, endText)
    }
}