package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TicketRepositoryImpl implements TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public int addTicket(Ticket ticket) {
        ticket.setId(tickets.size());
        tickets.add(ticket);
        return tickets.indexOf(ticket);
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        return tickets.remove(ticket);
    }

    @Override
    public boolean editTicket(Ticket ticket) {
        boolean exists = tickets.stream().anyMatch(t -> t.getId() == ticket.getId());
        if (!exists) {
            return false;
        }
        tickets.replaceAll(f -> f.getId() == ticket.getId() ? ticket : f);
        return true;
    }

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    @Override
    public Optional<Ticket> findById(final long id) {
        return tickets.stream().filter(t -> t.getId() == id).findFirst();
    }
}
