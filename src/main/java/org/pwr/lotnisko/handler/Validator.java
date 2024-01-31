package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.ReservationService;

import java.util.List;


public class Validator {

    public FlightService flightService;
    protected ReservationService reservationService;
    private List<PersonalData> personalDataList;

    public Validator(FlightService flightService, ReservationService reservationService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    public boolean validate(CheckInTo checkInTo) {
        long id_p = checkInTo.getTicket().getPersonalData().getId();
        boolean exists = personalDataList.stream()
                .anyMatch(person -> person.getId() == id_p);

        if (!exists) {
            // Osoba nie jest na liście, więc dodajemy ją
            personalDataList.add(checkInTo.getTicket().getPersonalData());
            return true;
        }

        // Osoba jest już na liście
        return false;
    }
}
