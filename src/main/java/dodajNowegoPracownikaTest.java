import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
import org.pwr.lotnisko.repository.EmployeeRepository;
import org.pwr.lotnisko.repository.EmployeeRepositoryImpl;
import org.pwr.lotnisko.service.EmployeeService;
import org.pwr.lotnisko.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
public class dodajNowegoPracownikaTest {

    private final EmployeeService employeeService;

    String firstName;
    String secondName;
    EmployeeRole role;
    Integer id;

    public dodajNowegoPracownikaTest() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        employeeRepository.addEmployee(new Employee(1, "Iwona", "dawda", EmployeeRole.WORKER));
        employeeRepository.addEmployee(new Employee(2, "daeda", "dawda", EmployeeRole.WORKER));
        employeeRepository.addEmployee(new Employee(3, "Iwondada", "dawda", EmployeeRole.ADMIN));
        this.employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
    }

    public boolean dodajPracownika() {
        Employee employee = Employee.builder()
                .id(id)
                .firstName(firstName)
                .secondName(secondName)
                .role(role)
                .build();
        Employee employeeResult = employeeService.addEmployee(employee);

        if(employeeResult == null)
            return false;

        if(employeeResult.getFirstName() == firstName && employeeResult.getSecondName() == secondName && employeeResult.getRole() == role)
            return true;



        return false;
    }

    public int liczbaPracownikow() {
        return employeeService.employeeCount();
    }
}
