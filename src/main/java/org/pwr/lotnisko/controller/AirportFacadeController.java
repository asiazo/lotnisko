package org.pwr.lotnisko.controller;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.TicketDto;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportFacadeController implements AirportFacade
{
    private final FlightService flightService;
    private final TicketService ticketService;

    @Override
    public TicketDto zakupBiletu(TicketDto ticketDto)
    {
        return ticketDto;
    }
}
