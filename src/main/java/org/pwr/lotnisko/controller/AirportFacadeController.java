package org.pwr.lotnisko.controller;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.service.CheckInService;
import org.pwr.lotnisko.service.CheckInServiceImpl;
import org.pwr.lotnisko.service.EmployeeService;
import org.pwr.lotnisko.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportFacadeController implements AirportFacade {
    private final ReservationService reservationService;
    private final EmployeeService employeeService;
    private final CheckInService checkInService;

    @Override
    public Reservation zakupBiletu(ReservationTO reservationTO) {

        Reservation reservationResult = reservationService.addReservation(reservationTO);

        if (reservationResult != null) {
            return reservationResult;
        } else {
            return null;
        }
    }

    @Override
    public Employee dodajNowegoPracownika(EmployeeTO employeeTO) {

        Employee employeeResult = employeeService.addEmployee(employeeTO);

        if(employeeResult != null)
            return employeeResult;

        return null;
    }

    @Override
    public CheckInTo checkIn(CheckInTo checkInTo) {
        CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        if(checkInTo != checkInResult)
            return checkInResult;
        return null;
    }


}
