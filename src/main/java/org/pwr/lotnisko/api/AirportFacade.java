package org.pwr.lotnisko.api;

import org.pwr.lotnisko.dto.TicketDto;
import org.pwr.lotnisko.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1")
public interface AirportFacade
{
    public TicketDto zakupBiletu(TicketDto ticketDto);
}
