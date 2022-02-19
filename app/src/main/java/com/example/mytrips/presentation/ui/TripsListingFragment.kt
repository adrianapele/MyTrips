package com.example.mytrips.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.databinding.FragmentTripsListingBinding
import com.example.mytrips.presentation.model.TripView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripsListingFragment: Fragment(), TripClickListener {

    private val viewModel: TripsListingViewModel by viewModels()

    private val navController: NavController
        get() = NavHostFragment.findNavController(this)

    private var binding: FragmentTripsListingBinding? = null
    private var recyclerView: RecyclerView? = null

    private val adapter: TripsAdapter by lazy {
        TripsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripsListingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setObservers()
    }

    private fun initViews() {
        recyclerView = binding?.rvTrips

    }

    private fun setObservers() {
        viewModel.tripsLiveData.observe(viewLifecycleOwner) {
            // load data to adapter
        }
    }

    override fun onTripClicked(tripView: TripView) {
        TODO("Not yet implemented")
    }
}