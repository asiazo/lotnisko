package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.model.CheckInStatus;

public class AuthenticationHandler implements CheckInHandler {
    private Validator validator;

    public AuthenticationHandler(Validator validator) {
        this.validator = validator;
    }


    public void apply(CheckInTo checkInTo) {
        boolean isValid = validator.flightService.vadateFlightNumber(checkInTo);
        if (isValid && validator.validate(checkInTo)) {
            process(checkInTo);
        }
    }

    @Override
    public void process(CheckInTo checkInTo) {
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_IN_PROGRESS);
    }
}
