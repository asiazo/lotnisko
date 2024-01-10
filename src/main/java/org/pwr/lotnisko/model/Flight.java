package org.pwr.lotnisko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    long id;

    String flightNumber;

    String source;

    String destination;

    int freePlaces;
}
