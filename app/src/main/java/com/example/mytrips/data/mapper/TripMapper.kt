package com.example.mytrips.data.mapper

import com.example.mytrips.data.model.TripDto
import com.example.mytrips.domain.model.Trip

class TripMapper(
    private val locationMapper: LocationMapper
) {

    fun mapDtoToModel(dto: TripDto): Trip {
        return Trip(
            id = dto.id,
            startTime = dto.startTime,
            endTime = dto.endTime,
            location = locationMapper.mapDtoToModel(dto.locationDto),
            image = dto.image
        )
    }
}