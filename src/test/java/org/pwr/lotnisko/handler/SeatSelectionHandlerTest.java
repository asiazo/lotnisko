package org.pwr.lotnisko.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckInStatus;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Ticket;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@ExtendWith(MockitoExtension.class)
class SeatSelectionHandlerTest {

    @Mock
    private Validator validator;

    @InjectMocks
    private SeatSelectionHandler seatSelectionHandler;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        seatSelectionHandler = new SeatSelectionHandler(validator);
        System.setOut(new PrintStream(outputStreamCaptor)); // for capturing System.out prints
    }

    @Test
    void apply_withAvailableSeats_shouldSelectSeat() {
        // given
        Ticket ticket = new Ticket(); // Assume Ticket is properly initialized
        Flight flight = new Flight(); // Assume Flight is properly initialized with free places
        flight.setFreePlaces(1);
        ticket.setFlight(flight);
        CheckInTo checkInTo = new CheckInTo();
        checkInTo.setTicket(ticket);
        when(validator.flightService.selectSeat(any())).thenReturn("1A");

        // when
        seatSelectionHandler.apply(checkInTo);

        // then
        assertThat(checkInTo.getCheckInStatus()).isEqualTo(CheckInStatus.CHECK_IN_IN_PROGRESS_SEET);
        assertThat(outputStreamCaptor.toString()).contains("wybrano miejsce: 1A");
    }

    @Test
    void apply_withNoAvailableSeats_shouldNotSelectSeat() {
        // given
        Ticket ticket = new Ticket(); // Assume Ticket is properly initialized
        Flight flight = new Flight(); // Assume Flight is properly initialized with no free places
        flight.setFreePlaces(0);
        ticket.setFlight(flight);
        CheckInTo checkInTo = new CheckInTo();
        checkInTo.setTicket(ticket);

        // when
        seatSelectionHandler.apply(checkInTo);

        // then
        assertThat(outputStreamCaptor.toString()).contains("brak miejsc");
    }
}
