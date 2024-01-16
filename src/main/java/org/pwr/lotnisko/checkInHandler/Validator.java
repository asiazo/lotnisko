package org.pwr.lotnisko.checkInHandler;

import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.ReservationRepository;

public class Validator {
    private FlightRepository flightService;
    private ReservationRepository reservationService;

    public Validator(FlightRepository flightService, ReservationRepository reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    public boolean validate(CheckIn checkIn) {
        // Tutaj logika walidacji
        return true; // lub false w zależności od wyniku walidacji
    }
}
