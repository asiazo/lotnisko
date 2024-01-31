package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.model.CheckInStatus;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.FlightRepository;

import java.util.List;

public class SeatSelectionHandler implements CheckInHandler {
    private Validator validator;

    public SeatSelectionHandler(Validator validator) {
        this.validator = validator;
    }

    @Override
    public CheckInTo apply(CheckInTo checkInTo) {
        // Tutaj logika aplikowania zmian związanych z wyborem miejsca
        Ticket ticket = checkInTo.getTicket();
        Flight flight = ticket.getFlight();
        int free = flight.getFreePlaces();
        if (free > 0) {
            process(checkInTo);
            String seet = validator.flightService.selectSeat(checkInTo);
        }
        else {
        }
        return checkInTo;
    }

    @Override
    public CheckInTo process(CheckInTo checkInTo) {
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_IN_PROGRESS_SEET);
        return checkInTo;
    }
}