package org.pwr.lotnisko.api;

import org.pwr.lotnisko.dto.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1")
public interface AirportFacade
{
    @PostMapping("bilety")
    public Ticket zakupBiletu();
}
