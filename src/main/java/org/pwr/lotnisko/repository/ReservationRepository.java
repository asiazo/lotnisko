package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.Reservation;

public interface ReservationRepository
{
    boolean addReservation(Reservation reservation);

    boolean removeReservation(Reservation reservation);

    boolean editReservation(Reservation reservation);
}
