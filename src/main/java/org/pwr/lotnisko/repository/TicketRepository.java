package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.TicketDto;

public interface TicketRepository
{
    boolean addTicket(TicketDto ticketDto);

    boolean removeTicket(TicketDto ticketDto);

    TicketDto editTicket(TicketDto ticketDto);

}
