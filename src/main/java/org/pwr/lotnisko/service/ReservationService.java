package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.ReservationDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

public interface ReservationService
{
    ReservationDto addReservation(ReservationDto reservationDto);

    ReservationDto removeReservation(ReservationDto reservationDto);

    ReservationDto editReservation(ReservationDto reservationDto);
}
