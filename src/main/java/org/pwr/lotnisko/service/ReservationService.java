package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.Reservation;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

public interface ReservationService
{
    Reservation addReservation(Reservation reservation);

    Reservation removeReservation(Reservation reservation);

    Reservation editReservation(Reservation reservation);
}
