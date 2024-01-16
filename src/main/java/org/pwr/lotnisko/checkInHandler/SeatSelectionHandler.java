package org.pwr.lotnisko.checkInHandler;

import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.repository.FlightRepository;

public class SeatSelectionHandler implements CheckInHandler {
    private FlightRepository flightService;

    public SeatSelectionHandler(FlightRepository flightService) {
        this.flightService = flightService;
    }

    @Override
    public void apply(CheckIn checkIn) {
        // Tutaj logika aplikowania zmian związanych z wyborem miejsca
    }

    @Override
    public void process(CheckIn checkIn) {

        // Tutaj logika przetwarzania wyboru miejsca
    }
}