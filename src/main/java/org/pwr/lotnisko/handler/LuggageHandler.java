package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LuggageHandler implements CheckInHandler {

    private Validator validator;

    public LuggageHandler(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void apply(CheckInTo checkInTo) {
        // Tutaj logika aplikowania zmian związanych z bagażem
        Scanner myObj = new Scanner(System.in);
        System.out.print("Czy klijent chce dodatkowy bagaż: t - tak,  n - nie");
        String decision = myObj.nextLine();
        if (decision == "t") {
            validator.flightService.addExtraLuggage(checkInTo);
        }
        process(checkInTo);
    }

    @Override
    public void process(CheckInTo checkInTo) {
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_COMPLETED);
    }
}
