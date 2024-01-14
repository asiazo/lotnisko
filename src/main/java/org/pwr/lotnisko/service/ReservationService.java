package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Reservation;


public interface ReservationService {
    Reservation addReservation(ReservationTO reservation);

    Reservation editReservation(Reservation reservation);

    Reservation deleteReservation(Reservation reservation);

    Reservation processReservation(Reservation reservation);
}
