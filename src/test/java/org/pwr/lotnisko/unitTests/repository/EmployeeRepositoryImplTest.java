package org.pwr.lotnisko.unitTests.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.repository.EmployeeRepository;
import org.pwr.lotnisko.repository.EmployeeRepositoryImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryImplTest {

    @InjectMocks
    EmployeeRepositoryImpl employeeRepository;

    @Test
    void addEmployee_shouldAddNewEmplyee()
    {
        // given
        Employee employee = Employee.builder().id(1).build();

        // when
        int employeeId = employeeRepository.addEmployee(employee);

        // then
        assertThat(employeeId).isGreaterThanOrEqualTo(0);
    }
}
