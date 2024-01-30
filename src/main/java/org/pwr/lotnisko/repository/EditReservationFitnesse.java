package org.pwr.lotnisko.repository;

import lombok.Getter;
import lombok.Setter;
import org.pwr.lotnisko.controller.AirportFacadeController;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.service.ReservationService;

import java.util.Date;

@Getter
@Setter
public class EditReservationFitnesse {
    private final ReservationService reservationService;
    AirportFacadeController test;
    Integer id;
    float reservationCost;
    Date date;

    public EditReservationFitnesse(ReservationService reservationService) {
        this.reservationService = reservationService;
        test = new AirportFacadeController();
    }

    public boolean editReservation() {
        Reservation reservation = Reservation.builder()
                .id(id)
                .reservationCost(reservationCost)
                .date(new Date())
                .build();

        Reservation result = test.edycjaRezerwacji(reservation);

        if(result.getReservationCost() == reservationCost && result.getId() == id && result.getDate() == date)
            return  true;
        return false;
    }
}
/*
!|Edit Reservation Fitnesse|
        |id|reservationCost|date            |editReservation?|
        |1 |200.0          |2024/01/29      |true            |
        |2 |150.0          |2024/01/30      |false           |

 */