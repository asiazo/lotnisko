package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationRepositoryImpl implements ReservationRepository
{

    private final List<Reservation> reservations = new ArrayList<>();

    @Override
    public int addReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservations.indexOf(reservation);
    }

    @Override
    public boolean removeReservation(Reservation reservation)
    {
        reservations.remove(reservation);
        return false;
    }

    @Override
    public boolean editReservation(Reservation reservation) {
        return false;
    }
}
