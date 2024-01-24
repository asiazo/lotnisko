package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.Ticket;


public interface TicketService
{
    Ticket addTicket(TicketTO ticket);

    boolean removeTicket(Ticket ticket);

    Ticket editTicket(Ticket ticket);
    Ticket findById(final long id);
}
