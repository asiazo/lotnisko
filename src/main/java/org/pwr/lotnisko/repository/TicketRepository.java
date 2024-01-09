package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.Ticket;

public interface TicketRepository
{
    boolean addTicket(Ticket ticket);

    boolean removeTicket(Ticket ticket);

    Ticket editTicket(Ticket ticket);

}
