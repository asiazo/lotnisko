package org.pwr.lotnisko.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    long id;
    Date date;
    Ticket ticket;
    CheckInStatus checkInStatus;
}
