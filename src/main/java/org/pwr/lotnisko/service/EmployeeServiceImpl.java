package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository emplyeeRepository;

    @Override
    public List<Employee> displayEmployees() {

        return null;
    }

    @Override
    public List<PersonalData> displayUsers() {

        return null;
    }

    @Override
    public List<PersonalData> displayFlightPassengers(Flight flight) {
        return null;
    }

    @Override
    public Employee addEmployee(EmployeeTO employeeTO) {

        boolean isEmployed = emplyeeRepository.searchEmployee(employeeTO);

        if(!isEmployed)
        {
            Employee employee = Employee.builder()
                    .firstName("Andrzej")
                    .secondName("Zawadzki")
                    .role(EmployeeRole.ADMIN)
                    .build();

            int employeeId = emplyeeRepository.addEmployee(employee);
            employee.setId(employeeId);
            return employee;
        }

        return null;
    }

    @Override
    public Employee deleteEmployee(EmployeeTO employee) {
        return null;
    }

}
