package org.pwr.lotnisko.repository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pwr.lotnisko.dto.CheckInTo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FlightRepositoryCheckInTest {

    @InjectMocks
    private FlightRepository flightRepository;

    @Mock
    private ReservationRepository reservationRepository;


    @Test
    void vadateFlightNumber_WithValidFlight_ShouldReturnTrue() {
        CheckInTo checkInTo = new CheckInTo();

        boolean isValid = flightRepository.vadateFlightNumber(checkInTo);
        assertTrue(isValid);
    }

    @Test
    void vadateFlightNumber_WithInvalidFlight_ShouldReturnFalse() {
        CheckInTo checkInTo = new CheckInTo();

        boolean isValid = flightRepository.vadateFlightNumber(checkInTo);
        assertFalse(isValid);
    }

    @Test
    void selectSeat_WhenCalled_ShouldDecreaseFreePlaces() {
        CheckInTo checkInTo = new CheckInTo();

        String seat = flightRepository.selectSeat(checkInTo);
        assertNotNull(seat);

    }

    @Test
    void addExtraLuggage_WhenCalled_ShouldIncreaseTicketPrice() {
        CheckInTo checkInTo = new CheckInTo();
        float initialPrice = checkInTo.getTicket().getPrice();

        flightRepository.addExtraLuggage(checkInTo);
        assertEquals(initialPrice + 10, checkInTo.getTicket().getPrice());
    }

}
