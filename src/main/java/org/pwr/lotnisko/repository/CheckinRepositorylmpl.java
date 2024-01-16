package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.handler.*;
import org.pwr.lotnisko.model.CheckIn;
import org.pwr.lotnisko.model.CheckInStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckinRepositorylmpl implements CheckinRepository {

    private List<CheckIn> checkins = new ArrayList<>();
    private  List<CheckInHandler> checkinsHandles = new ArrayList<>();

    public CheckinRepositorylmpl(FlightRepository flightRepository, ReservationRepository reservationRepository) {
        Validator validator = new Validator(flightRepository, reservationRepository);
        AuthenticationHandler authenticationHandler = new AuthenticationHandler(validator);
        checkinsHandles.add(authenticationHandler);
        SeatSelectionHandler seatSelectionHandler = new SeatSelectionHandler(validator);
        checkinsHandles.add(seatSelectionHandler);
        LuggageHandler luggageHandler = new LuggageHandler(validator);
        checkinsHandles.add(luggageHandler);
    }

    @Override
    public CheckInTo processWithCheckin(CheckInTo checkInTo) {
        checkInTo.setCheckInStatus(CheckInStatus.CHECK_IN_PENDING);
        checkinsHandles.get(0).apply(checkInTo);
        int id = checkins.size();
        if (checkInTo.getCheckInStatus() == CheckInStatus.CHECK_IN_IN_PROGRESS) {
            CheckIn check = new CheckIn(checkInTo.getId(), checkInTo.getDate(), checkInTo.getTicket(), checkInTo.getCheckInStatus());
            checkins.add(check);
            checkinsHandles.get(1).apply(checkInTo);
        }
        if (checkInTo.getCheckInStatus() == CheckInStatus.CHECK_IN_IN_PROGRESS_SEET) {
            checkinsHandles.get(2).apply(checkInTo);
        }
        if (checkInTo.getCheckInStatus() == CheckInStatus.CHECK_IN_COMPLETED) {
            checkins.get(id).setCheckInStatus(CheckInStatus.CHECK_IN_COMPLETED);
        }
        return checkInTo;
    }
}
