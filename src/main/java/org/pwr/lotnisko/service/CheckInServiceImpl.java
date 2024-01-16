package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.repository.CheckinRepository;
import org.pwr.lotnisko.repository.CheckinRepositorylmpl;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.ReservationRepository;

public class CheckInServiceImpl implements CheckInService{
    private final CheckinRepository chceckinRepository;

    public CheckInServiceImpl(FlightRepository flightRepository, ReservationRepository reservationRepository) {
        this.chceckinRepository = new CheckinRepositorylmpl(flightRepository,reservationRepository);
        };

    @Override
    public CheckInTo processWithCheckin(CheckInTo checkInTo) {
        checkInTo = chceckinRepository.processWithCheckin(checkInTo);
        return checkInTo;
    }
}

