package org.pwr.lotnisko.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket
{
    long id;
    float price;
    //long flightId;
    Flight flight;
    long userId;

    @JsonIgnore
    boolean success;
}
