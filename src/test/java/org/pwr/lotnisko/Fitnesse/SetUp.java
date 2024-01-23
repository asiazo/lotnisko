package org.pwr.lotnisko.Fitnesse;

import fit.Fixture;
import lombok.Builder;
import org.pwr.lotnisko.AirportApplication;
import org.pwr.lotnisko.controller.AirportFacadeController;
import org.pwr.lotnisko.service.CheckInService;
import org.pwr.lotnisko.service.EmployeeService;
import org.pwr.lotnisko.service.ReservationService;

// klasa inicjująca obiekty testowane w testach akceptacyjnych

@Builder
public class SetUp extends Fixture
{
    protected AirportFacadeController airportFacadeController;
    protected CheckInService checkInService;
    protected ReservationService reservationService;
    protected EmployeeService employeeService;

}
