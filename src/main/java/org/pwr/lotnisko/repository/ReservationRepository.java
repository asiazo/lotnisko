package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Reservation;

public interface ReservationRepository
{
    int addReservation(Reservation reservation);

    boolean removeReservation(Reservation reservation);

    boolean editReservation(Reservation reservation);
}
