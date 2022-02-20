package com.example.mytrips.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.R
import com.example.mytrips.databinding.FragmentTripsListingBinding
import com.example.mytrips.domain.model.Trip
import com.example.mytrips.utils.ProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripsListingFragment: Fragment(), TripClickListener {

    private val viewModel: TripsSharedViewModel by activityViewModels()

    private val navController: NavController
        get() = NavHostFragment.findNavController(this)

    private var binding: FragmentTripsListingBinding? = null
    private var recyclerView: RecyclerView? = null

    private val adapter: TripsAdapter by lazy {
        TripsAdapter(this)
    }

    private var progressDialog: AlertDialog? = null

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

        activity?.setTitle(R.string.toolbar_trips)

        initViews()
        setObservers()
    }

    private fun initViews() {
        progressDialog = ProgressDialog(requireContext()).create()
        progressDialog?.show()

        recyclerView = binding?.rvTrips
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter
    }

    private fun setObservers() {
        viewModel.tripsViewLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            progressDialog?.dismiss()
        }
    }

    override fun onTripClicked(trip: Trip) {
        val action = TripsListingFragmentDirections.actionTripsListingToTripsDetails(trip.id)
        navController.navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()

        if (progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }
}