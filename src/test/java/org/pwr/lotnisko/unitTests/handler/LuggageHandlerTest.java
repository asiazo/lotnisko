package org.pwr.lotnisko.unitTests.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.handler.LuggageHandler;
import org.pwr.lotnisko.handler.Validator;
import org.pwr.lotnisko.model.CheckInStatus;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LuggageHandlerTest {

    @Mock
    private Validator validator;

    @InjectMocks
    private LuggageHandler luggageHandler;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        luggageHandler = new LuggageHandler(validator);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void apply_withExtraLuggage_shouldAddLuggage() {
        // given
        String input = "t\n"; // Simulating user input "t" for yes
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CheckInTo checkInTo = new CheckInTo();

        // when
        luggageHandler.apply(checkInTo);

        // then
        verify(validator.flightService).addExtraLuggage(checkInTo);
        assertThat(checkInTo.getCheckInStatus()).isEqualTo(CheckInStatus.CHECK_IN_COMPLETED);
    }

    @Test
    void apply_withoutExtraLuggage_shouldNotAddLuggage() {
        // given
        String input = "n\n"; // Simulating user input "n" for no
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CheckInTo checkInTo = new CheckInTo();

        // when
        luggageHandler.apply(checkInTo);

        // then
        verify(validator.flightService, never()).addExtraLuggage(checkInTo);
        assertThat(checkInTo.getCheckInStatus()).isEqualTo(CheckInStatus.CHECK_IN_COMPLETED);
    }

}
