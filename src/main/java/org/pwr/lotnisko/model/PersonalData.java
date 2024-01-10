package org.pwr.lotnisko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {
    long id;

    String firstName;

    String secondName;

    String passportNumber;
}
