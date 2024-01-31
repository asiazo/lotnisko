package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final TicketService ticketService;

    private final FlightService flightService;

    @Override
    public Reservation addReservation(ReservationTO reservationTO) {
        float reservationCost = 100 + (new Random().nextFloat() * (1000 - 100));

        Flight flight = flightService.findById(reservationTO.getTicket().getFlightId());

        if (flight.getFreePlaces() == 0) {
            return Reservation.builder().success(false).build();
        }

        Ticket ticket = ticketService.addTicket(reservationTO.getTicket());
        Reservation reservation = Reservation.builder()
                .ticket(ticket)
                .reservationCost(reservationCost + ticket.getPrice())
                .date(new Date())
                .success(true)
                .build();

        int reservationId = reservationRepository.addReservation(reservation);
        reservation.setId(reservationId);
        return reservation;
    }

    @Override
    public Reservation deleteReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation editReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservation.getId());

        if (existingReservation == null) {
            return null;
        }

        existingReservation.setDate(reservation.getDate());
        existingReservation.setTicket(reservation.getTicket());
        existingReservation.setReservationCost(reservation.getReservationCost());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public Reservation processReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
