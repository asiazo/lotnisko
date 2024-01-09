package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.Flight;

public interface FlightRepository
{

    boolean addFlight(Flight flight);

    boolean removeFlight(Flight flight);

    Flight editFlight(Flight flight);
}
