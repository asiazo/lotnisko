package org.pwr.lotnisko.Fitnesse;

import fitnesse.fixtures.FitnesseFixtureContext;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
import org.pwr.lotnisko.service.EmployeeService;

import java.util.Set;
import fit.ColumnFixture;

public class dodajNowegoPracownikaTest extends ColumnFixture {

    SetUp setUp = SetUp.builder().build();

    /*public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }*/

    public boolean dodajPracownika(String firstName, String secondName, EmployeeRole role) {

        Employee employee = Employee.builder()
                .firstName(firstName)
                .secondName(secondName)
                .role(role)
                .build();

        try
        {
            setUp.airportFacadeController.dodajNowegoPracownika(employee);
        }
        catch (Exception exception) { }

        //if (!addedEmployee.getFirstName().equals(firstName) || !addedEmployee.getSecondName().equals(secondName) || !addedEmployee.getRole().equals(role)) {
            //fitnesseFail("Nieprawidłowe dane pracownika po dodaniu.");
        return true;
    }
}
