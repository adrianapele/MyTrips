package com.example.mytrips.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.R
import com.example.mytrips.databinding.ViewItemTripHeaderDetailsBinding
import com.example.mytrips.domain.model.Trip
import com.squareup.picasso.Picasso

class TripsHeaderDetailsAdapter(
    private val listener: TripClickListener
): ListAdapter<Trip, TripHeaderDetailsViewHolder>(DiffUtilCallbackTrips()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHeaderDetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val inflate = ViewItemTripHeaderDetailsBinding.inflate(layoutInflater, parent, false)
        return TripHeaderDetailsViewHolder(inflate, listener)
    }

    override fun onBindViewHolder(holder: TripHeaderDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TripHeaderDetailsViewHolder(
    private val view: ViewItemTripHeaderDetailsBinding,
    private val listener: TripClickListener
): RecyclerView.ViewHolder(view.root) {

    fun bind(trip: Trip) {
        Picasso.get().load(trip.image).into(view.ivTrip)

        val startDetails = "${trip.location.startAddress.city} ${trip.startTime}"
        val endDetails = "${trip.location.endAddress.city} ${trip.endTime}"
        val details = view.container.context.getString(R.string.trip_details_short, startDetails, endDetails)
        view.tvDetails.text = details

        view.container.setOnClickListener { listener.onTripClicked(trip) }
    }
}

class DiffUtilCallbackTrips: DiffUtil.ItemCallback<Trip>() {
    override fun areItemsTheSame(oldItem: Trip, newItem: Trip): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Trip, newItem: Trip): Boolean {
        return oldItem ==  newItem
    }
}