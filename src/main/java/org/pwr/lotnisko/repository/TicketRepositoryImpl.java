package org.pwr.lotnisko.repository;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketRepositoryImpl implements TicketRepository
{

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public boolean addTicket(Ticket ticket) {
        tickets.add(ticket);
        return false;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        return false;
    }

    @Override
    public Ticket editTicket(Ticket ticket) {
        return ticket;
    }
}
