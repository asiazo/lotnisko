package org.pwr.lotnisko.dto;

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
public class ReservationDto
{
    long id;
    Date date;
    TicketDto ticket;   // ? czy lista biletow? oraz Ticket czy TicketDto ?
    FlightDto flight;
    //reservationStatus
    float reservationCost;

    @JsonIgnore
    boolean success;
}
