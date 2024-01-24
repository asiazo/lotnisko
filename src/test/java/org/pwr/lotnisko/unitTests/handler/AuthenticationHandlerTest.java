//package org.pwr.lotnisko.unitTests.handler;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.pwr.lotnisko.dto.CheckInTo;
//import org.pwr.lotnisko.handler.AuthenticationHandler;
//import org.pwr.lotnisko.handler.Validator;
//import org.pwr.lotnisko.model.CheckInStatus;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.any;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(MockitoExtension.class)
//class AuthenticationHandlerTest {
//
//    @Mock
//    private Validator validator;
//
//    @InjectMocks
//    private AuthenticationHandler authenticationHandler;
//
//    @BeforeEach
//    void setUp() {
//        authenticationHandler = new AuthenticationHandler(validator);
//    }
//
//    @Test
//    void apply_withValidCheckInTo_shouldUpdateStatus() {
//        // given
//        CheckInTo checkInTo = new CheckInTo();
//        when(validator.flightService.vadateFlightNumber(any())).thenReturn(true);
//        when(validator.validate(any())).thenReturn(true);
//
//        // when
//        authenticationHandler.apply(checkInTo);
//
//        // then
//        assertThat(checkInTo.getCheckInStatus()).isEqualTo(CheckInStatus.CHECK_IN_IN_PROGRESS);
//    }
//
//    @Test
//    void apply_withInvalidCheckInTo_shouldNotUpdateStatus() {
//        // given
//        CheckInTo checkInTo = new CheckInTo();
//        when(validator.flightService.vadateFlightNumber(any())).thenReturn(false);
//        when(validator.validate(any())).thenReturn(false);
//
//        // when
//        authenticationHandler.apply(checkInTo);
//
//        // then
//        assertThat(checkInTo.getCheckInStatus()).isNotEqualTo(CheckInStatus.CHECK_IN_IN_PROGRESS);
//    }
//}
