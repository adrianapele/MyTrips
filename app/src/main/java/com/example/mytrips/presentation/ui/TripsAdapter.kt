package com.example.mytrips.presentation.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytrips.presentation.model.TripView

class TripsAdapter: ListAdapter<TripView, TripsViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TripsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class TripsViewHolder(
    private val listener: TripClickListener,
): RecyclerView.ViewHolder() {

}

class DiffUtilCallback: DiffUtil.ItemCallback<TripView>() {
    override fun areItemsTheSame(oldItem: TripView, newItem: TripView): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: TripView, newItem: TripView): Boolean {
        TODO("Not yet implemented")
    }

}