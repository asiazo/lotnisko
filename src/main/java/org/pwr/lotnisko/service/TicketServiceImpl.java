package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.TicketDto;
import org.pwr.lotnisko.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService
{
    private final TicketRepository ticketRepository;

    @Override
    public TicketDto addTicket(TicketDto ticketDto) {
        boolean success = ticketRepository.addTicket(ticketDto);
        return TicketDto.builder().id(123123).success(success).build();
    }

    @Override
    public boolean removeTicket(TicketDto ticketDto) {
        return true;
    }

    @Override
    public TicketDto editTicket(TicketDto ticketDto) {
        return null;
    }
}
