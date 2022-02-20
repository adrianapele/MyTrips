package com.example.mytrips.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.mytrips.R

class ProgressDialog(
    private val context: Context
) {

    fun create(): AlertDialog {
        return AlertDialog.Builder(context).apply {
            setCancelable(false)
            setView(R.layout.progress_dialog)
        }.create()
    }
}