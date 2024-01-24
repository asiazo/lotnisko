package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Flight;

public interface EmployeeRepository {
    void displayEmployees();
    void displayUsers();
    void displayFlightPassengers(Flight flight);
    boolean searchEmployee(EmployeeTO employeeTO);
    int addEmployee(Employee employee);
    int getEmployeeCount();
    boolean removeEmployee(Employee employee);
    boolean checkIn();
    boolean addUpdate();
}
