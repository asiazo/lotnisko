package org.pwr.lotnisko.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    long id;

    Date date;

    Ticket ticket;

    float reservationCost;

    @JsonIgnore
    boolean success;

    //PersonalData user;
    //ReservationStatus reservationStatus;
}
