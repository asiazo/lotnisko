import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
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

    public dodajNowegoPracownikaTest() {
        this.employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
    }

    public boolean dodajPracownika() {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .secondName(secondName)
                .role(EmployeeRole.WORKER)
                .build();
        Employee employeeResult = employeeService.addEmployee(employee);

        return employee.getFirstName().equals("Iwona");
    }
}
