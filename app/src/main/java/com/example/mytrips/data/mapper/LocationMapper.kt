package com.example.mytrips.data.mapper

import com.example.mytrips.data.model.LocationDto
import com.example.mytrips.domain.model.Location

class LocationMapper(
    private val addressMapper: AddressMapper
) {

    fun mapDtoToModel(dto: LocationDto): Location {
        return Location(
            startAddress = addressMapper.mapDtoToModel(dto.startAddressDto),
            endAddress = addressMapper.mapDtoToModel(dto.endAddressDto)
        )
    }
}