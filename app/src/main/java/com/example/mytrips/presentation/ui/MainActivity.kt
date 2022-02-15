package com.example.mytrips.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mytrips.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.exampleLiveData.observe(this) {
            Log.d("onCreate", "on observe $it")
        }

        viewModel.tripsLiveData.observe(this) {
            Log.d("onCreate", "$it")
        }
    }
}