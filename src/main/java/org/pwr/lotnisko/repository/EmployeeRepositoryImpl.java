package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.PersonalData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final List<Employee> employees = new ArrayList<>();
    private final List<PersonalData> users = new ArrayList<>();

    @Override
    public void displayEmployees() {
        for(Employee employee : employees)
        {
            System.out.println(employee);
        }
    }

    @Override
    public void displayUsers() {
        for(PersonalData user : users)
        {
            System.out.println(user);
        }
    }

    @Override
    public void displayFlightPassengers(Flight flight) {

    }

    @Override
    public boolean searchEmployee(EmployeeTO employeeTO) {

        for(Employee e : employees)
        {
            if(e.getId() == employeeTO.getId())
                return true;
        }

        return false;
    }

    @Override
    public int addEmployee(Employee employee) {
        employees.add(employee);
        return employees.indexOf(employee);
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        employees.remove(employee);
        return true;
    }

    @Override
    public boolean checkIn() {
        return false;
    }

    @Override
    public boolean addUpdate() {
        return false;
    }
}
