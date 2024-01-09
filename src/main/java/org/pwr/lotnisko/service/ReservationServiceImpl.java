package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Reservation;
import org.pwr.lotnisko.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService
{
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation)
    {
        boolean success = reservationRepository.addReservation(reservation);
        return Reservation.builder().id(1).success(success).build();
    }

    @Override
    public Reservation removeReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation editReservation(Reservation reservation) {
        return null;
    }
}
