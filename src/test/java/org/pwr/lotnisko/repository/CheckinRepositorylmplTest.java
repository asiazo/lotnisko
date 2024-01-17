package org.pwr.lotnisko.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.*;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CheckinRepositorylmplTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private CheckinRepositorylmpl checkinRepositorylmpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void processWithCheckin_ShouldProcessCheckInCorrectly() {
        // given
        CheckInTo checkInTo = new CheckInTo();
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_PENDING);


        // when
        CheckInTo result = checkinRepositorylmpl.processWithCheckin(checkInTo);

        // then
        assertThat(result.getCheckInStatus()).isEqualTo(CheckInStatus.CHECK_IN_COMPLETED);
    }

}
