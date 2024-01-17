package org.pwr.lotnisko.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.*;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.ReservationRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ValidatorTest {

    @Mock
    private FlightRepository flightService;

    @Mock
    private ReservationRepository reservationService;

    @InjectMocks
    private Validator validator;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // for capturing System.out prints
    }

    @Test
    void validate_withCorrectData_shouldReturnTrue() {
        // given
        String input = "t\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CheckInTo checkInTo = new CheckInTo();
        PersonalData personalData = new PersonalData(1, "John", "Doe", "123456789", null);
        Flight flight = new Flight();
        Ticket ticket = new Ticket(123, 200.0f, flight, personalData, DiscountType.NONE);
        checkInTo.setTicket(ticket);

        // when
        boolean result = validator.validate(checkInTo);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void validate_withIncorrectData_shouldReturnFalse() {
        // given
        String input = "n\n"; // Simulating user input "n" for incorrect data
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CheckInTo checkInTo = new CheckInTo();
        PersonalData personalData = new PersonalData(1, "John", "Doe", "123456789", null);
        Flight flight = new Flight();
        Ticket ticket = new Ticket(123, 200.0f, flight, personalData, DiscountType.NONE);
        checkInTo.setTicket(ticket);

        // when
        boolean result = validator.validate(checkInTo);

        // then
        assertThat(result).isFalse();
    }

}
