package org.pwr.lotnisko.unitTests.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.repository.FlightRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;


class FlightRepositoryImplTest {
    private FlightRepositoryImpl flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository = new FlightRepositoryImpl();
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

        // when
        int result = flightRepository.addFlight(flight);

        // then
        assertThat(result).isZero();
    }
}