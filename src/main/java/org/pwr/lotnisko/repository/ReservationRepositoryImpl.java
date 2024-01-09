package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationRepositoryImpl implements ReservationRepository
{

    private final List<Reservation> reservations = new ArrayList<>();

    @Override
    public boolean addReservation(Reservation reservation)
    {
        reservations.add(reservation);
        return false;
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
