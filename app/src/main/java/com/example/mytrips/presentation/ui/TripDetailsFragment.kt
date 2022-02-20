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
            binding?.tvStartDetails?.text = "test"
            Picasso.get().load(it.image).into(binding?.ivTripImage)
        }
    }
}