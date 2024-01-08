package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.pwr.lotnisko.mapper.ReservationMapper;
import org.pwr.lotnisko.model.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository
{

    private final ModelMapper modelMapper = new ModelMapper();
    private final ReservationMapper reservationMapper  = Mappers.getMapper(ReservationMapper.class);

    private final List<Reservation> reservations = new ArrayList<>();

    @Override
    public boolean addReservation(ReservationDto reservationDto)
    {
        reservations.add(reservationMapper.toReservation(reservationDto));
        return false;
    }

    @Override
    public boolean removeReservation(ReservationDto reservationDto)
    {
        reservations.remove(reservationMapper.toReservation(reservationDto));
        return false;
    }

    @Override
    public boolean editReservation(ReservationDto reservationDto) {
        return false;
    }
}
