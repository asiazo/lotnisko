package org.pwr.lotnisko.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pwr.lotnisko.dto.FlightDto;
import org.pwr.lotnisko.model.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight toFlight(FlightDto dto);
}
