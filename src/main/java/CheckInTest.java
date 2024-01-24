import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckInStatus;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
import org.pwr.lotnisko.model.Ticket;
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
    private final CheckInService checkInService = new CheckInServiceImpl(new CheckinRepositorylmpl(flightService, reservationService));
    long id_c;
    Date date;
    //    long id_t;
    //    float price;
    //    Flight flight;
    //    PersonalData personalData;
    //    DiscountType discountType;
    public CheckInTest() {}

    public boolean CheckIn() {
        Ticket ticket = Ticket.builder().build();

        CheckInTo checkInTo = CheckInTo.builder()
                .checkInStatus(CheckInStatus.CHECK_IN_PENDING)
                .ticket(ticket)
                .id(id_c)
                .date(date)
                .build();

        CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        if(checkInResult.getCheckInStatus() == CheckInStatus.CHECK_IN_COMPLETED)
            return true;
        return false;
    }
}
/*
*
*
*
* ---------------- plik testowy ---------------------
*!define TEST_SYSTEM {slim}

!path C:\Users\Justy\IdeaProjects\lotnisko2\target\classes

|CheckInTest|
|id_c      | date        | CheckIn?              |
|1         |  24.01.2024 | false                 |
* */