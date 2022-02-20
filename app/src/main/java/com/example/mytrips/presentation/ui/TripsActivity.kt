package com.example.mytrips.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytrips.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}