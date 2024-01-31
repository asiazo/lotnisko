package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckInStatus;

public class AuthenticationHandler implements CheckInHandler {
    private Validator validator;

    public AuthenticationHandler(Validator validator) {
        this.validator = validator;
    }


    public CheckInTo apply(CheckInTo checkInTo) {
        boolean isValid = validator.flightService.vadateFlightNumber(checkInTo);
        if (isValid && validator.validate(checkInTo)) {
            process(checkInTo);
        }
        return checkInTo;
    }

    @Override
    public CheckInTo process(CheckInTo checkInTo) {
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_IN_PROGRESS);
        return checkInTo;
    }
}
