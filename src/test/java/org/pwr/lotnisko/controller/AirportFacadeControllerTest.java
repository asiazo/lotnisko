package org.pwr.lotnisko.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.pwr.lotnisko.dto.EmployeeTO;
import org.pwr.lotnisko.dto.ReservationTO;
import org.pwr.lotnisko.dto.TicketTO;
import org.pwr.lotnisko.model.DiscountType;
import org.pwr.lotnisko.model.Employee;
import org.pwr.lotnisko.model.EmployeeRole;
import org.pwr.lotnisko.model.Flight;
import org.pwr.lotnisko.model.Reservation;
import org.pwr.lotnisko.model.Ticket;
import org.pwr.lotnisko.service.EmployeeService;
import org.pwr.lotnisko.service.ReservationService;
import org.pwr.lotnisko.testutils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class AirportFacadeControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void zakupBiletu_shouldReturnReservationWithTicket() throws Exception {
        // given
        Flight flight = Flight.builder()
                .id(1L)
                .flightNumber("LAX1234")
                .source("Warsaw")
                .destination("Los Angeles")
                .freePlaces(50).build();

        Ticket ticket = Ticket.builder()
                .price(403f)
                .discountType(DiscountType.STUDENT)
                .flight(flight).build();

        Reservation reservation = Reservation.builder()
                .id(1L)
                .ticket(ticket)
                .reservationCost(403f)
                .date(new Date())
                .build();
        when(reservationService.addReservation(ArgumentMatchers.any(ReservationTO.class)))
                .thenReturn(reservation);

        // when
        ResultActions result = mvc.perform(post("/api/v1/zakupbiletu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.getJson(ReservationTO.builder()
                        .ticket(TicketTO.builder().flightId(1L).discountType(DiscountType.STUDENT)
                                .flightId(1L).build()).build())));

        // then
        result.andExpect(status().isOk());
        // TODO: add result body to check for null
    }

    @Test
    void dodajNowegoPracownika() throws Exception {
        // given
        Employee employee = Employee.builder()
                .id(1)
                .firstName("Test Name")
                .secondName("Test SecondName").role(EmployeeRole.WORKER)
                .build();

        when(employeeService.addEmployee(any(EmployeeTO.class))).thenReturn(employee);

        // when
        ResultActions result = mvc.perform(post("/api/v1/dodajNowegoPracownika")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.getJson(EmployeeTO.builder().id(1).build())));

        // then
        result.andExpect(status().isOk())
                .andExpect(content().string(JsonUtils.getJson(employee)));
    }
}