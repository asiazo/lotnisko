package org.pwr.lotnisko.fixture;

import lombok.Getter;
import lombok.Setter;
import org.pwr.lotnisko.controller.AirportFacadeController;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.model.ReservationStatus;
import org.pwr.lotnisko.repository.FlightRepository;
import org.pwr.lotnisko.repository.FlightRepositoryImpl;

import java.util.Optional;


@Setter
@Getter
public class ReservationFixture {

    private AirportFacadeController airportFacadeController;

    Integer userId;

    Integer flightId;

    DiscountType discountType;

    ReservationStatus expectedReservationStatus;

    Float expectedCost = null;

    Long expectedFlightId = null;

    Long expectedId = null;

    public ReservationFixture() {
        FlightRepository flightRepository = new FlightRepositoryImpl();
        flightRepository.addFlight(new Flight(0L, "LAX1341", "Honk Kong", "Los Angeles", 0));
        flightRepository.addFlight(new Flight(1L, "LAX1234", "Warsaw", "Los Angeles", 50));
        airportFacadeController = new AirportFacadeController(flightRepository);
    }

    public boolean testReservation() {
        TicketTO ticket = TicketTO.builder()
                .userId(userId)
                .flightId(flightId)
                .discountType(discountType)
                .build();
        Reservation result = airportFacadeController.zakupBiletu(ticket);

        expectedReservationStatus = result.getReservationStatus();
        expectedCost = result.getReservationCost();

        if (result.getTicket() == null) {
            expectedFlightId = null;
        } else {
            expectedFlightId = result.getTicket().getFlight().getId();
        }
        expectedId = result.getId();
        return result.isSuccess();
    }
}


// !define TEST_SYSTEM {slim}
//
//         !path D:\studies\lotnisko\target\classes
//
//         |org.pwr.lotnisko.fixture.ReservationFixture|
//         |userId    | flightId  | discountType          | testReservation? | getExpectedReservationStatus? | getExpectedId? | getExpectedCost?    | getExpectedFlightId? |
//         |0         |  0        | STUDENT               | false            | CANCELLED                     | null           | 0.0                 | null                 |
//         |0         |  1        | STUDENT               | true             | CONFIRMED			          | 0              | 510.0               | 1                    |
//         |0         |  1        | WORKER                | true             | CONFIRMED			          | 1              | 800.0               | 1                    |
//         |0         |  1        | SENIOR                | true             | CONFIRMED			          | 2              | 700.0               | 1                    |