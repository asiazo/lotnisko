package org.pwr.lotnisko.controller;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportFacadeController implements AirportFacade {


    private final ReservationService reservationService;

    @Override
    public Reservation zakupBiletu(ReservationTO reservationTO) {

        Reservation reservationResult = reservationService.addReservation(reservationTO);

        if (reservationResult != null) {
            return reservationResult;
        } else {
            return null;
        }
    }
}
