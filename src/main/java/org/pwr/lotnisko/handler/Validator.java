package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.ReservationRepository;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.ReservationService;

import java.util.Scanner;

public class Validator {

    public FlightService flightService;

    protected ReservationService reservationService;

    public Validator(FlightService flightService, ReservationService reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    public boolean validate(CheckInTo checkInTo) {
        PersonalData personalData = checkInTo.getTicket().getPersonalData();
        System.out.print("Dane: ");
        System.out.print(personalData.getFirstName() + " ");
        System.out.print(personalData.getSecondName() + " ");
        return true;
    }
}
