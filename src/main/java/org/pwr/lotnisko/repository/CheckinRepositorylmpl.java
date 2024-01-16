package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.checkInHandler.CheckInHandler;
import org.pwr.lotnisko.model.CheckIn;

public class CheckinRepositorylmpl {
    private TicketRepository ticketRepository;
    private ReservationRepository reservationRepository;
    private CheckIn[] checkins;
    private CheckInHandler[] checkinsHandles;

    public CheckinRepositorylmpl(TicketRepository biletRepository, ReservationRepository reservationRepository) {
        this.ticketRepository = ticketRepository;
        this.reservationRepository = reservationRepository;

    }

    public boolean processWithCheckin(CheckIn checkIn) {
        return true;
    }
}
