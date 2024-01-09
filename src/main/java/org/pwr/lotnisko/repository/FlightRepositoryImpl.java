package org.pwr.lotnisko.repository;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.Flight;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRepositoryImpl implements FlightRepository
{
    private final List<Flight> flights = new ArrayList<>();

    @Override
    public boolean addFlight(Flight flight)
    {
        flights.add(flight);
        return true;
    }

    @Override
    public boolean removeFlight(Flight flight)
    {
        flights.remove(flight);
        return true;
    }

    @Override
    public Flight editFlight(Flight flight) {
        return flight;
    }
}
