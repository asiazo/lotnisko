package org.pwr.lotnisko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pwr.lotnisko.model.DiscountType;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketTO {
    long flightId;

    long userId;

    DiscountType discountType;
}
