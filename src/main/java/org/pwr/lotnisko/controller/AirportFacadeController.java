package org.pwr.lotnisko.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.repository.CheckinRepositorylmpl;
import org.pwr.lotnisko.repository.EmployeeRepositoryImpl;
import org.pwr.lotnisko.repository.FlightRepositoryImpl;
import org.pwr.lotnisko.repository.ReservationRepositoryImpl;
import org.pwr.lotnisko.repository.TicketRepositoryImpl;
import org.pwr.lotnisko.repository.UserRepositoryImpl;
import org.pwr.lotnisko.service.CheckInService;
import org.pwr.lotnisko.service.CheckInServiceImpl;
import org.pwr.lotnisko.service.EmployeeService;
import org.pwr.lotnisko.service.EmployeeServiceImpl;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.FlightServiceImpl;
import org.pwr.lotnisko.service.ReservationService;
import org.pwr.lotnisko.service.ReservationServiceImpl;
import org.pwr.lotnisko.service.TicketService;
import org.pwr.lotnisko.service.TicketServiceImpl;
import org.pwr.lotnisko.service.UserService;
import org.pwr.lotnisko.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

public class AirportFacadeController implements AirportFacade {
    private final FlightService flightService = new FlightServiceImpl(new FlightRepositoryImpl());
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    private final TicketService ticketService =  new TicketServiceImpl(new TicketRepositoryImpl(),userService ,flightService);
    private final ReservationService reservationService = new ReservationServiceImpl(new ReservationRepositoryImpl(),ticketService, flightService);
    private final EmployeeService employeeService  = new EmployeeServiceImpl(new EmployeeRepositoryImpl());

    @Override
    public Reservation zakupBiletu(ReservationTO reservationTO) {

        // Reservation reservationResult = reservationService.addReservation(reservationTO);
        //
        // if (reservationResult != null) {
        //     return reservationResult;
        // } else {
        //     return null;
        // }
        return new Reservation();
    }

    @Override
    public Employee dodajNowegoPracownika(Employee employee) {

        Employee employeeResult = employeeService.addEmployee(employee);

        if(employeeResult != null)
            return employeeResult;

        return null;
    }

    @Override
    public CheckInTo checkIn(CheckInTo checkInTo) {
        // CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        // if(checkInTo != checkInResult)
        //     return checkInResult;
        // return null;
        return new CheckInTo();
    }
        @Override
    public Reservation edycjaRezerwacji(Reservation reservation)
    {
        Reservation reservationResult = reservationService.editReservation(reservation);

        if (reservationResult != null) {
            return reservationResult;
        } else {
            return null;
        }
    }


}
