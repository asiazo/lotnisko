package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Flight;
import org.pwr.lotnisko.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight)
    {
        boolean success =  flightRepository.addFlight(flight);
        return Flight.builder().flightNumber("WT435").success(success).build();
    }
}
