package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ReservationRepositoryImpl implements ReservationRepository {

    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public int addReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservations.indexOf(reservation);
    }

    @Override
    public boolean removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        return false;
    }

    @Override
    public boolean editReservation(Reservation reservation) {
        int index = reservations.indexOf(reservation);
        if (index != -1) {
            reservations.remove(index);
            reservations.add(index, reservation);
            return true;
        }
        return false;
    }

    @Override
    public Reservation findById(long id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation save(Reservation reservation) {
        int id = addReservation(reservation);
        reservation.setId(id);
        return reservation;
    }
}
