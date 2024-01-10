package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    private static final List<String> AIRPORT_ACRONYMS = List.of(
            "LAX",
            "JFK",
            "DXB",
            "HND",
            "LHR",
            "CDG");

    @Override
    public Flight addFlight(Flight flight) {
        String airportAcronym = getRandomAirportAcronym();
        int number = new Random().nextInt(9000) + 1000;
        String flightNumber = airportAcronym + number;

        long flightId = flightRepository.addFlight(flight);
        return Flight.builder()
                .id(flightId).source(flight.getSource())
                .destination(flight.getDestination())
                .flightNumber(flightNumber)
                .freePlaces(flight.getFreePlaces())
                .build();
    }

    @Override
    public Flight findById(final long id) {
        return flightRepository.findById(id).get();
    }

    private String getRandomAirportAcronym() {
        Random random = new Random();
        return AIRPORT_ACRONYMS.get(random.nextInt(AIRPORT_ACRONYMS.size()));
    }
}
