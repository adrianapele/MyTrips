package com.example.mytrips.data.mapper

import com.example.mytrips.data.model.TripDto
import com.example.mytrips.domain.model.Trip
import com.example.mytrips.utils.DateTimeFormatter
import javax.inject.Inject

class TripMapper @Inject constructor(
    private val locationMapper: LocationMapper,
    private val dateTimeFormatter: DateTimeFormatter
) {

    fun mapDtoToModel(dto: TripDto): Trip {
        val startDateTime = dateTimeFormatter.format(dto.startTime)
        val endDateTime = dateTimeFormatter.format(dto.startTime)

        return Trip(
            id = dto.id,
            startDate =  startDateTime.first,
            startTime = startDateTime.second,
            endDate = endDateTime.first,
            endTime = endDateTime.second,
            location = locationMapper.mapDtoToModel(dto.locationDto),
            image = dto.image
        )
    }
}