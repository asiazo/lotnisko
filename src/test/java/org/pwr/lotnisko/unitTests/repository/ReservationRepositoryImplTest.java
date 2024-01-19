package org.pwr.lotnisko.unitTests.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.ReservationRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;


@ExtendWith(MockitoExtension.class)
class ReservationRepositoryImplTest {

    private ReservationRepositoryImpl reservationRepository;

    @BeforeEach
    void setUp() {
        reservationRepository = new ReservationRepositoryImpl();
    }

    @Test
    void addReservation_shouldSaveNewReservation() {
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

        Reservation reservation = Reservation.builder()
                .ticket(ticket)
                .reservationCost(403f)
                .date(new Date())
                .build();
        // when
        int result = reservationRepository.addReservation(reservation);

        // then
        assertThat(result).isZero();
    }

}