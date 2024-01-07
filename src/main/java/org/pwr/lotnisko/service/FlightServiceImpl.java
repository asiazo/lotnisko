package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.FlightDto;
import org.pwr.lotnisko.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        boolean success =  flightRepository.addFlight(flightDto);
        return FlightDto.builder().flightNumber("WT435").success(success).build();
    }
}
