package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.ReservationRepository;

import java.util.Scanner;

public class Validator {
    public FlightRepository flightService;
    protected ReservationRepository reservationService;

    public Validator(FlightRepository flightService, ReservationRepository reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    public boolean validate(CheckInTo checkInTo) {
        PersonalData personalData = checkInTo.getTicket().getPersonalData();
        System.out.print("Dane: ");
        System.out.print(personalData.getFirstName() + " ");
        System.out.print(personalData.getSecondName() + " ");
        System.out.println(personalData.getPassportNumber() + " ");
        Scanner myObj = new Scanner(System.in);
        System.out.print("Czy są poprawne: t - tak,  n - nie");
        String decision = myObj.nextLine();
        if (decision == "t")
            return true;
        else
            return false;
        }
    }
