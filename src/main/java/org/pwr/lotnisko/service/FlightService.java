package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Flight;
import org.springframework.stereotype.Service;


public interface FlightService {
    Flight addFlight(Flight flight);
}
