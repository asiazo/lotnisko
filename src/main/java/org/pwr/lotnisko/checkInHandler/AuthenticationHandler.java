package org.pwr.lotnisko.checkInHandler;

import org.pwr.lotnisko.model.CheckIn;

public class AuthenticationHandler implements CheckInHandler {
    private Validator validator;

    public AuthenticationHandler(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void apply(CheckIn checkIn) {
        // Tutaj logika aplikowania zmian związanych z uwierzytelnieniem
    }

    @Override
    public void process(CheckIn checkIn) {

        // Tutaj logika przetwarzania uwierzytelnienia
        if (validator.validate(checkIn)) {
            // Logika, jeśli walidacja przebiegła pomyślnie
        } else {
            // Logika, jeśli walidacja się nie powiodła
        }
    }
}
