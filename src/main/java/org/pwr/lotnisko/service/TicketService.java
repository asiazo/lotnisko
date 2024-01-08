package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.TicketDto;
import org.springframework.stereotype.Service;

public interface TicketService
{
    TicketDto addTicket(TicketDto ticketDto);

    boolean removeTicket(TicketDto ticketDto);

    TicketDto editTicket(TicketDto ticketDto);
}
