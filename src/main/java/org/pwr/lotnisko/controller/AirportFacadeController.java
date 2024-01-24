package org.pwr.lotnisko.controller;

import org.pwr.lotnisko.api.AirportFacade;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.repository.CheckinRepositorylmpl;
import org.pwr.lotnisko.repository.EmployeeRepositoryImpl;
import org.pwr.lotnisko.repository.FlightRepository;
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


public class AirportFacadeController implements AirportFacade {

    private FlightRepository flightRepository;

    private FlightService flightService;

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    private TicketService ticketService;

    private ReservationService reservationService;

    private final EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());

    private final CheckInService checkInService = new CheckInServiceImpl(new CheckinRepositorylmpl());

    public AirportFacadeController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
        flightService = new FlightServiceImpl(flightRepository);

        ticketService = new TicketServiceImpl(
                new TicketRepositoryImpl(),
                userService,
                flightService);
        reservationService = new ReservationServiceImpl(
                new ReservationRepositoryImpl(),
                ticketService,
                flightService);

        reservationService = new ReservationServiceImpl(
                new ReservationRepositoryImpl(),
                ticketService,
                flightService);
    }

    @Override
    public Reservation zakupBiletu(TicketTO ticketTO) {

        Reservation reservationResult = reservationService.addReservation(ticketTO);

        if (reservationResult != null) {
            return reservationResult;
        }
        return null;
    }

    @Override
    public Employee dodajNowegoPracownika(Employee employee) {

        Employee employeeResult = employeeService.addEmployee(employee);

        if (employeeResult != null) {
            return employeeResult;
        }

        return null;
    }

    @Override
    public CheckInTo checkIn(CheckInTo checkInTo) {
        CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        if (checkInTo != checkInResult) {
            return checkInResult;
        }
        return null;
    }

    @Override
    public Reservation edycjaRezerwacji(Reservation reservation) {
        Reservation reservationResult = reservationService.editReservation(reservation);

        if (reservationResult != null) {
            return reservationResult;
        } else {
            return null;
        }
    }
}
