package org.pwr.lotnisko.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.repository.EmployeeRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void addEmployee_shouldAddNewEmployee() {
        // given
        EmployeeTO employeeTO = EmployeeTO.builder().id(1).build();

        when(employeeRepository.searchEmployee(any())).thenReturn(false);
        when(employeeRepository.addEmployee(any())).thenReturn(2);

        // when
        Employee result = employeeService.addEmployee(employeeTO);

        // then
        assertThat(result.getFirstName()).isEqualTo("Andrzej");
    }

    @Test
    void addEmployee_shouldntAddNewEmployee() {

        // Proba dodania pracownika, ktory jest juz zatrudniony

        // given
        EmployeeTO employeeTO = EmployeeTO.builder().id(1).build();

        when(employeeRepository.searchEmployee(any())).thenReturn(true);

        // when
        Employee result = employeeService.addEmployee(employeeTO);

        // then
        assertThat(result).isNull();
    }

}