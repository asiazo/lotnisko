package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.CheckIn;

public interface CheckinRepository {
    void CheckinRepositorylmpl(TicketRepository biletRepository, FlightRepository lotRepository);

    boolean processWithCheckin(CheckIn checkIn);
}
