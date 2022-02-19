package com.example.mytrips.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.databinding.ViewItemTripHeaderBinding
import com.example.mytrips.presentation.model.TripView

class TripsAdapter(
    private val listener: TripClickListener
): ListAdapter<TripView, TripsViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ViewItemTripHeaderBinding.inflate(inflater, parent, false)
        return TripsViewHolder(listener, view)
    }

    override fun onBindViewHolder(holder: TripsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
class TripsViewHolder(
    private val listener: TripClickListener,
    private val view: ViewItemTripHeaderBinding
): RecyclerView.ViewHolder(view.root) {

    fun bind(tripView: TripView) {
        view.tvHeader.text = tripView.tripGroupDay

        val adapter = TripsHeaderDetailsAdapter(listener)
        view.rvHeaderDetails.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.VERTICAL, false)
        view.rvHeaderDetails.adapter = adapter
        adapter.submitList(tripView.trips)
    }
}

class DiffUtilCallback: DiffUtil.ItemCallback<TripView>() {

    override fun areItemsTheSame(oldItem: TripView, newItem: TripView): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: TripView, newItem: TripView): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}