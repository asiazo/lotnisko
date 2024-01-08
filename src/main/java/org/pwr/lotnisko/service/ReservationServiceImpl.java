package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.ReservationDto;
import org.pwr.lotnisko.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService
{
    private final ReservationRepository reservationRepository;

    @Override
    public ReservationDto addReservation(ReservationDto reservationDto)
    {
        boolean success = reservationRepository.addReservation(reservationDto);
        return ReservationDto.builder().id(1).success(success).build();
    }

    @Override
    public ReservationDto removeReservation(ReservationDto reservationDto) {
        return null;
    }

    @Override
    public ReservationDto editReservation(ReservationDto reservationDto) {
        return null;
    }
}
