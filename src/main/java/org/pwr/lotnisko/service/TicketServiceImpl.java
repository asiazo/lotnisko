package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final UserService userService;

    private final FlightService flightService;

    private static final Map<DiscountType, Float> discounts = Map.of(
            DiscountType.SENIOR, 0.7f,
            DiscountType.STUDENT, 0.51f,
            DiscountType.WORKER, 0.8f);

    @Override
    public Ticket addTicket(TicketTO ticketTO) {
        DiscountType discountType = ticketTO.getDiscountType();
        float ticketPrice = getTicketPrice(discountType);
        PersonalData personalData = userService.getPersonalData(ticketTO.getUserId());
        Flight flight = flightService.findById(ticketTO.getFlightId());

        Ticket ticket = Ticket.builder()
                .discountType(discountType)
                .price(ticketPrice)
                .personalData(personalData).flight(flight)
                .build();
        int ticketId = ticketRepository.addTicket(ticket);
        ticket.setId(ticketId);
        return ticket;
    }

    private float getTicketPrice(final DiscountType discountType) {
        return 1000 * discounts.get(discountType);
    }

    @Override
    public boolean removeTicket(Ticket ticketDto) {
        return ticketRepository.removeTicket(ticketDto);
    }

    @Override
    public Ticket editTicket(Ticket ticketDto) {
        ticketRepository.editTicket(ticketDto);
        return ticketDto;
    }
}
