package org.pwr.lotnisko.unitTests.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.ReservationRepository;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.ReservationServiceImpl;
import org.pwr.lotnisko.service.TicketService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private FlightService flightService;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    private final ReservationTO contentTO = ReservationTO.builder()
            .ticket(TicketTO.builder()
                    .discountType(DiscountType.STUDENT)
                    .flightId(1L)
                    .userId(1L)
                    .build())
            .build();

    @BeforeEach
    void setUp() {
        reservationService =
                new ReservationServiceImpl(reservationRepository, ticketService, flightService);
    }

    @Test
    void addReservation_shouldCreateATicketForPlane_success() {
        // given
        Flight flight = Flight.builder()
                .id(1L)
                .flightNumber("LAX1234")
                .source("Warsaw")
                .destination("Los Angeles")
                .freePlaces(50).build();

        Ticket ticket = Ticket.builder()
                .price(403f)
                .discountType(DiscountType.STUDENT)
                .flight(flight).build();

        when(flightService.findById(1)).thenReturn(flight);
        when(ticketService.addTicket(contentTO.getTicket())).thenReturn(ticket);
        when(reservationRepository.addReservation(any())).thenReturn(1);

        // when
        Reservation result = reservationService.addReservation(contentTO);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getId()).isOne();
        assertThat(result.getTicket().getFlight()).isEqualTo(flight);
    }

    @Test
    void addReservation_shouldNotCreateTicket_NoEnoughSpaceOnPlane() {
        // given
        Flight flight = Flight.builder()
                .id(1L)
                .flightNumber("LAX1234")
                .source("Warsaw")
                .destination("Los Angeles")
                .freePlaces(0)
                .build();

        when(flightService.findById(1)).thenReturn(flight);

        // when
        Reservation result = reservationService.addReservation(contentTO);

        // then
        assertThat(result.isSuccess()).isFalse();
    }
}
