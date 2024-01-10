package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Ticket;

import java.util.List;
import java.util.Optional;


public interface TicketRepository {
    int addTicket(Ticket ticket);

    boolean removeTicket(Ticket ticket);

    boolean editTicket(Ticket ticket);

    List<Ticket> findAll();

    Optional<Ticket> findById(long id);

}
