import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.TicketTO;
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
    private final CheckInService checkInService = new CheckInServiceImpl(new CheckinRepositorylmpl(flightService, reservationService));
    long id_c = 1;
    long id_t;

    int freePlaces;
    public CheckInTest() {

        String flightNumber = "1";
        String source = "a";
        String destination = "b";
        long id_f = 1;

        Flight flight = new Flight().builder()
                .flightNumber(flightNumber)
                .source(source)
                .id(id_f)
                .destination(destination)
                .freePlaces(20)
                .build();

       flightService.addFlight(flight);

        String firstName = "Adam";
        String secondName = "Kowalski";
        String passportNumber = "1234";
        Abonament abonament = null;
        long id_p = 1;

        PersonalData personalData = new PersonalData().builder()
                .passportNumber(passportNumber)
                .firstName(firstName)
                .secondName(secondName)
                .abonament(abonament)
                .id(id_p)
                .build();

        userService.addPersonalData(personalData);

        ticketService.addTicket(new org.pwr.lotnisko.dto.TicketTO(flight.getId(),personalData.getId(),DiscountType.NONE));

        firstName = "Marta";
        secondName = "Kowalski";
        passportNumber = "1434";
        abonament = null;
        id_p = 2;

        personalData = new PersonalData().builder()
                .passportNumber(passportNumber)
                .firstName(firstName)
                .secondName(secondName)
                .abonament(abonament)
                .id(id_p)
                .build();

        userService.addPersonalData(personalData);

        ticketService.addTicket(new org.pwr.lotnisko.dto.TicketTO(flight.getId(),personalData.getId(),DiscountType.NONE));
    }

    public boolean CheckIn() {
        Ticket ticket = ticketService.findById(id_t);
        Date date = new Date();

        CheckInTo checkInTo = CheckInTo.builder()
                .checkInStatus(CheckInStatus.CHECK_IN_PENDING)
                .ticket(ticket)
                .id(id_c)
                .date(date)
                .build();

        CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        if(checkInResult.getCheckInStatus() == CheckInStatus.CHECK_IN_COMPLETED && checkInResult != checkInTo) {
            id_c = id_c + 1;
            return true;
        }
        return false;
    }
}
/*

---------------- plik testowy ---------------------
!define ChcekInTest {slim}

!path C:\Users\Justy\IdeaProjects\lotnisko2\target\classes

|CheckInTest|
|id_t      | CheckIn?              |
|1         | true                  |
|2         | true                  |
|1         | false                 |
|2         | false                 |
|3         | false                 |

*/