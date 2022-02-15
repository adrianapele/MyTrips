package com.example.mytrips.data.mapper

import com.example.mytrips.data.model.AddressDto
import com.example.mytrips.domain.model.Address
import javax.inject.Inject

class AddressMapper @Inject constructor() {

    fun mapDtoToModel(dto: AddressDto): Address {
        return Address(
            city = dto.city,
            county = dto.county,
            country = dto.country
        )
    }
}