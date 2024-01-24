package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.PersonalData;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface EmployeeService {
    List<Employee> displayEmployees();
    List<PersonalData> displayUsers();
    List<PersonalData> displayFlightPassengers(Flight flight);
    Employee addEmployee(Employee employee);
    Employee deleteEmployee(EmployeeTO employee);

    int employeeCount();
}
