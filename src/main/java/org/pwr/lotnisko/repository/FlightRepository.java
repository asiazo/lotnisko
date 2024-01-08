package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.FlightDto;

public interface FlightRepository {

    boolean addFlight(FlightDto flightDto);

    boolean removeFlight(FlightDto flightDto);

    FlightDto editFlight(FlightDto flightDto);
}
