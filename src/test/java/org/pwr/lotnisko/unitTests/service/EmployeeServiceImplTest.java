//package org.pwr.lotnisko.unitTests.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.pwr.lotnisko.dto.EmployeeTO;
//import org.pwr.lotnisko.model.Employee;
//import org.pwr.lotnisko.repository.EmployeeRepository;
//import org.pwr.lotnisko.service.EmployeeServiceImpl;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeServiceImplTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    EmployeeServiceImpl employeeService;
//
//    @BeforeEach
//    void setUp() {
//        employeeService = new EmployeeServiceImpl(employeeRepository);
//    }
//
//    @Test
//    void addEmployee_shouldAddNewEmployee() {
//        // given
//        Employee employee = Employee.builder().id(1).build();
//
//        when(employeeRepository.searchEmployee(any())).thenReturn(false);
//        when(employeeRepository.addEmployee(any())).thenReturn(2);
//
//        // when
//        Employee result = employeeService.addEmployee(employee);
//
//        // then
//        assertThat(result.getFirstName()).isEqualTo(employee.getFirstName());
//    }
//
//    @Test
//    void addEmployee_shouldntAddNewEmployee() {
//
//        // Proba dodania pracownika, ktory jest juz zatrudniony
//
//        // given
//        Employee employee = Employee.builder().id(1).build();
//
//        when(employeeRepository.searchEmployee(any())).thenReturn(true);
//
//        // when
//        Employee result = employeeService.addEmployee(employee);
//
//        // then
//        assertThat(result).isNull();
//    }
//
//}