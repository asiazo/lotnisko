package org.pwr.lotnisko.api;

import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("api/v1")
public interface AirportFacade {

    @PostMapping("zakupbiletu")
    Reservation zakupBiletu(@RequestBody ReservationTO reservationTO);

    @PostMapping("dodajNowegoPracownika")
    Employee dodajNowegoPracownika(@RequestBody EmployeeTO employeeTO);
}
