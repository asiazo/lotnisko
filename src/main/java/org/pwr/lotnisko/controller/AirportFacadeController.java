package org.pwr.lotnisko.controller;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.Flight;
import org.pwr.lotnisko.dto.Reservation;
import org.pwr.lotnisko.dto.Ticket;
import org.pwr.lotnisko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportFacadeController implements AirportFacade
{
    private final FlightServiceImpl flightService;
    private final TicketServiceImpl ticketService;
    private final ReservationServiceImpl reservationService;

    @Override
    public Ticket zakupBiletu()
    {
        Flight flight = Flight.builder()
                .id(1)
                .flightNumber("WTA435")
                .source("Rome")
                .destination("Las Vegas")
                .freePlaces(100)
                .build();

        flightService.addFlight(flight);

        Ticket ticket = Ticket.builder()
                .id(1)
                .price(1679)
                .flight(flight)
                .userId(168526)
                .build();

        ticketService.addTicket(ticket);

        Date date = new Date(2024, 6, 28);

        Reservation reservation = Reservation.builder()
                .id(1)
                .date(date)
                .ticket(ticket)
                .flight(flight)
                .reservationCost(ticket.getPrice())
                .build();

        Reservation reservationResult = reservationService.addReservation(reservation);

        if(reservationResult != null)
        {
            Ticket reservationTicket = reservation.getTicket();
            return reservationTicket;
        }
        else
            return null;

    }
}
