package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public boolean vadateFlightNumber(CheckInTo checkInTo) {
        long id = checkInTo.getTicket().getFlight().getId();
        Flight flight = findById(id);
        return flight != null;
    }

    @Override
    public String selectSeat(CheckInTo checkInTo) {
        long id = checkInTo.getTicket().getFlight().getId();
        Flight flight = findById(id);
        String a = String.valueOf(flight.getFreePlaces());
        flight.setFreePlaces(flight.getFreePlaces() - 1);
        return a;
    }

    @Override
    public void addExtraLuggage(CheckInTo checkInTo) {}
}
