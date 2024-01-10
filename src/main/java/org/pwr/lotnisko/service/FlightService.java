package org.pwr.lotnisko.service;

import org.pwr.lotnisko.model.Flight;


public interface FlightService {
    Flight addFlight(Flight flight);

    Flight findById(long id);
}
