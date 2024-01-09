package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Ticket;
import org.springframework.stereotype.Service;

public interface TicketService
{
    Ticket addTicket(Ticket ticket);

    boolean removeTicket(Ticket ticket);

    Ticket editTicket(Ticket ticket);
}
