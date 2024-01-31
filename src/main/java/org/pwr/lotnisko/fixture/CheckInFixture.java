package org.pwr.lotnisko.fixture;

import lombok.Getter;
import lombok.Setter;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.CheckInStatus;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.repository.CheckinRepositorylmpl;
import org.pwr.lotnisko.repository.FlightRepositoryImpl;
import org.pwr.lotnisko.repository.ReservationRepositoryImpl;
import org.pwr.lotnisko.repository.TicketRepositoryImpl;
import org.pwr.lotnisko.repository.UserRepositoryImpl;
import org.pwr.lotnisko.service.CheckInService;
import org.pwr.lotnisko.service.CheckInServiceImpl;
import org.pwr.lotnisko.service.FlightService;
import org.pwr.lotnisko.service.FlightServiceImpl;
import org.pwr.lotnisko.service.ReservationService;
import org.pwr.lotnisko.service.ReservationServiceImpl;
import org.pwr.lotnisko.service.TicketService;
import org.pwr.lotnisko.service.TicketServiceImpl;
import org.pwr.lotnisko.service.UserService;
import org.pwr.lotnisko.service.UserServiceImpl;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Date;


@Setter
@Getter
public class CheckInFixture {

    private FlightService flightService;

    private UserService userService;

    private TicketService ticketService;

    private ReservationService reservationService;

    private CheckInService checkInService;

    Long cId = 1L;

    int tId;

    Flight flight = Flight.builder()
            .flightNumber("1")
            .source("a")
            .id(1)
            .destination("b")
            .freePlaces(20)
            .build();

    PersonalData personalData = PersonalData.builder()
            .passportNumber("1234")
            .firstName("Adam")
            .secondName("Kowalski")
            .id(1)
            .build();

    PersonalData personalData2 = PersonalData.builder()
            .passportNumber("1434")
            .firstName("Marta")
            .secondName("Kowalski")
            .id(2)
            .build();

    public CheckInFixture() {
        flightService = new FlightServiceImpl(new FlightRepositoryImpl());
        flightService.addFlight(flight);

        userService = new UserServiceImpl(new UserRepositoryImpl());
        userService.addPersonalData(personalData);
        userService.addPersonalData(personalData2);

        ticketService = new TicketServiceImpl(new TicketRepositoryImpl(), userService, flightService);
        ticketService.addTicket(new TicketTO(flight.getId(), personalData.getId(), DiscountType.WORKER));
        ticketService.addTicket(new TicketTO(flight.getId(), personalData2.getId(), DiscountType.WORKER));

        reservationService = new ReservationServiceImpl(new ReservationRepositoryImpl(), ticketService, flightService);

        checkInService = new CheckInServiceImpl(new CheckinRepositorylmpl(flightService, reservationService));
    }

    public boolean checkIn() {
        Ticket ticket = ticketService.findById(tId);
        Date date = new Date();

        CheckInTo checkInTo = CheckInTo.builder()
                .checkInStatus(CheckInStatus.CHECK_IN_PENDING)
                .ticket(ticket)
                .id(cId)
                .date(date)
                .build();

        CheckInTo checkInResult = checkInService.processWithCheckin(checkInTo);
        if (checkInResult.getCheckInStatus() == CheckInStatus.CHECK_IN_COMPLETED && checkInResult != checkInTo) {
            cId = cId + 1;
            return true;
        }
        return false;
    }
}
/*

---------------- plik testowy ---------------------
!define CheckInFixture {slim}

!path C:\Users\Justy\IdeaProjects\lotnisko2\target\classes

|org.pwr.lotnisko.fizture.CheckInFixture|
|id_t      | checkIn?              |
|1         | true                  |
|2         | true                  |
|1         | false                 |
|2         | false                 |
|3         | false                 |

*/