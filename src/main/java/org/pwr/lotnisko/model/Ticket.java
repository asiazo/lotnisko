package org.pwr.lotnisko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    long id;

    float price;

    Flight flight;

    PersonalData personalData;

    DiscountType discountType;
}
