package org.pwr.lotnisko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pwr.lotnisko.model.CheckInStatus;
import org.pwr.lotnisko.model.Ticket;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInTo {
    long id;
    Date date;
    Ticket ticket;
    CheckInStatus checkInStatus;
}
