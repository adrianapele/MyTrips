package com.example.mytrips.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.databinding.FragmentTripsListingBinding
import com.example.mytrips.domain.model.Trip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripsListingFragment: Fragment(), TripClickListener {

    private val viewModel: TripsListingViewModel by viewModels()

    private val navController: NavController
        get() = NavHostFragment.findNavController(this)

    private var binding: FragmentTripsListingBinding? = null
    private var recyclerView: RecyclerView? = null

    private val adapter: TripsAdapter by lazy {
        TripsAdapter(this)
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
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter


    }

    private fun setObservers() {
        viewModel.tripsViewLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onTripClicked(trip: Trip) {
        Toast.makeText(context, "Clicked: trip with id ${trip.id}", Toast.LENGTH_LONG).show()
    }
}