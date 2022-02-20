package com.example.mytrips.utils

import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateTimeFormatter @Inject constructor() {

    fun format(dateTime: String): Pair<String, String> {
        val millis = DateTime.parse(dateTime).millis

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        val calendarDate = calendar.time

        val dateFormatter = SimpleDateFormat("EEEE, MMM d", Locale.getDefault())
        val date = dateFormatter.format(calendarDate)

        val timeFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        val time = timeFormatter.format(calendarDate)

        return date to time
    }
}