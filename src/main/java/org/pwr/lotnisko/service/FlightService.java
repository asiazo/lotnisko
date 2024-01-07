package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.FlightDto;
import org.springframework.stereotype.Service;


public interface FlightService {
    FlightDto addFlight(FlightDto flightDto);
}
