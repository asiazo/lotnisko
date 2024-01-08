package org.pwr.lotnisko.repository;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.pwr.lotnisko.dto.TicketDto;
import org.pwr.lotnisko.mapper.TicketMapper;
import org.pwr.lotnisko.model.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketRepositoryImpl implements TicketRepository
{
    private final ModelMapper modelMapper = new ModelMapper();
    private final TicketMapper ticketMapper  = Mappers.getMapper(TicketMapper.class);

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public boolean addTicket(TicketDto ticketDto) {
        tickets.add(ticketMapper.toTicket(ticketDto));
        return false;
    }

    @Override
    public boolean removeTicket(TicketDto ticketDto) {
        tickets.remove(ticketMapper.toTicket(ticketDto));
        return false;
    }

    @Override
    public TicketDto editTicket(TicketDto ticketDto) {
        return ticketDto;
    }
}
