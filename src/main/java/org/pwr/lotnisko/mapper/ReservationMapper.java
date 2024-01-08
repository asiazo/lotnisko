package org.pwr.lotnisko.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pwr.lotnisko.dto.ReservationDto;
import org.pwr.lotnisko.model.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper
{
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation toReservation(ReservationDto dto);
}
