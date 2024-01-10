package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.Flight;

import java.util.List;
import java.util.Optional;


public interface FlightRepository {

    int addFlight(Flight flight);

    void removeFlight(Flight flight);

    boolean editFlight(Flight flight);

    List<Flight> findAll();

    Optional<Flight> findById(long id);
}
