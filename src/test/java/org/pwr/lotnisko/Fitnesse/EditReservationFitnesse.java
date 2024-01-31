package org.pwr.lotnisko.Fitnesse;

import lombok.Getter;
import lombok.Setter;
import org.pwr.lotnisko.controller.AirportFacadeController;
import org.pwr.lotnisko.model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


@Getter
@Setter
public class EditReservationFitnesse {

    AirportFacadeController test;

    Integer id;

    float reservationCost;

    String date;

    public EditReservationFitnesse() {
        test = new AirportFacadeController();
    }

    public boolean editReservation() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        Reservation reservation = Reservation.builder()
                .id(id)
                .reservationCost(reservationCost)
                .date(formatter.parse(date))
                .build();

        Reservation result = test.edycjaRezerwacji(reservation);

        if (result == null) {
            return false;
        }

        return result.getReservationCost() == reservationCost && result.getId() == id
               && result.getDate().equals(formatter.parse(date));
    }
}
/*
!define TEST_SYSTEM {slim}


!path D:\studies\lotnisko\target\classes
!path D:\studies\lotnisko\target\test-classes

|org.pwr.lotnisko.Fitnesse.EditReservationFitnesse|
|id|reservationCost|date            |editReservation?|
|1 |200.0          |29-01-2024      |true            |
|2 |150.0          |30-01-2024      |true            |
|3 |150.0          |30-01-2024      |false            |
 */