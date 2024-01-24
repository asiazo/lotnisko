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
    Date date;
    long id_t;
    float price;
    Ticket ticket;
    Flight flight;
    long id_p = 1;
    String firstName;
    String secondName;
    String passportNumber;
    Abonament abonament;
    long id_f = 1;
    String flightNumber = "1";
    String source = "a";
    String destination = "b";

    int freePlaces;
    public CheckInTest() {
        firstName = "Adam";
        secondName = "Kowalski";
        passportNumber = "1234";
        abonament = null;
        id_p = 1;

        flight = new Flight().builder()
                .flightNumber(flightNumber)
                .source(source)
                .id(id_f)
                .destination(destination)
                .freePlaces(20)
                .build();

        flight = flightService.addFlight(flight);

        PersonalData personalData = new PersonalData().builder()
                .passportNumber(passportNumber)
                .firstName(firstName)
                .secondName(secondName)
                .abonament(abonament)
                .id(id_p)
                .build();

        userService.addPersonalData(personalData);

        ticket = ticketService.addTicket(new org.pwr.lotnisko.dto.TicketTO(flight.getId(),personalData.getId(),DiscountType.NONE));
    }

    public boolean CheckIn() {
        ticket = ticketService.findById(id_t);

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
*
*
*
* ---------------- plik testowy ---------------------
*!define TEST_SYSTEM {slim}

!path C:\Users\Justy\IdeaProjects\lotnisko2\target\classes

|CheckInTest|
|id_t      | CheckIn?              |
|1         | true                  |
|2         | false                 |
|1         | false                 |
* */