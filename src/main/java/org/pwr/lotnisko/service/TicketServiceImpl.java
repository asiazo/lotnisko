package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Ticket;
import org.pwr.lotnisko.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService
{
    private final TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket ticket)
    {
        boolean success = ticketRepository.addTicket(ticket);
        return Ticket.builder().id(1).success(success).build();
    }

    @Override
    public boolean removeTicket(Ticket ticketDto) {
        return true;
    }

    @Override
    public Ticket editTicket(Ticket ticketDto) {
        return null;
    }
}
