import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.handler.AuthenticationHandler;
import org.pwr.lotnisko.handler.Validator;
import org.pwr.lotnisko.model.*;
import org.pwr.lotnisko.repository.*;
import org.pwr.lotnisko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@Setter
public class CheckInTest {
    private final FlightService flightService = new FlightServiceImpl(new FlightRepositoryImpl());
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    private final TicketService ticketService =  new TicketServiceImpl(new TicketRepositoryImpl(),userService ,flightService);
    private final ReservationService reservationService = new ReservationServiceImpl(new ReservationRepositoryImpl(),ticketService, flightService);
    Validator validator = new Validator(flightService, reservationService);
    AuthenticationHandler authenticationHandler = new AuthenticationHandler(validator);

    long id_c = 1;
    public long id_t;

    Flight flight = Flight.builder()
            .flightNumber("1")
            .source("a")
            .id(1)
            .destination("b")
            .freePlaces(20)
            .build();

    PersonalData personalData_1 = PersonalData.builder()
            .passportNumber("1234")
            .firstName("Adam")
            .secondName("Kowalski")
            .abonament(null)
            .id(1)
            .build();

    PersonalData personalData_2 = PersonalData.builder()
            .passportNumber("1434")
            .firstName("Marta")
            .secondName("Kowalski")
            .abonament(null)
            .id(2)
            .build();

    public CheckInTest(){
        flightService.addFlight(flight);

        userService.addPersonalData(personalData_1);

        ticketService.addTicket(new org.pwr.lotnisko.dto.TicketTO(flight.getId(),personalData_1.getId(),DiscountType.NONE));

        userService.addPersonalData(personalData_2);

        ticketService.addTicket(new org.pwr.lotnisko.dto.TicketTO(flight.getId(),personalData_2.getId(),DiscountType.NONE));
    }

    public boolean CheckIn() {

        CheckInTo checkInTo = CheckInTo.builder()
                .checkInStatus(CheckInStatus.CHECK_IN_PENDING)
                .id(id_c)
                .date(new Date())
                .ticket(ticketService.findById(id_t))
                .build();

        authenticationHandler.apply(checkInTo);
        if(checkInTo.getCheckInStatus() == CheckInStatus.CHECK_IN_PENDING){
            return false;
        }
        return true;
    }
}
/*

---------------- plik testowy ---------------------
!define CheckInTest {slim}

!path C:\Users\Justy\IdeaProjects\lotnisko2\target\classes

|CheckInTest|
|id_t      | CheckIn?              |
|1         | true                  |
|2         | true                  |
|1         | false                 |
|2         | false                 |
|3         | false                 |

*/