package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.ReservationDto;

public interface ReservationRepository
{
    boolean addReservation(ReservationDto reservationDto);

    boolean removeReservation(ReservationDto reservationDto);

    boolean editReservation(ReservationDto reservationDto);
}
