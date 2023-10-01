package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.service.ActiveBookingService;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import com.divby0exc.testingandci.service.TransportationRouteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class TicketBookingControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TransportationRouteService routeService;
    @Autowired
    AccountService accountService;
    @Autowired
    ActiveBookingService bookingService;
    @Autowired
    PaymentHistoryService paymentService;

    TransportationRoute transportationRoute = new TransportationRoute();
    Account account = new Account();

    @BeforeEach
    void init() throws InvalidEstimatedDepartureInputException, InvalidArrivalPointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidDeparturePointInputException, InvalidTicketPriceInputException, InvalidAuthTypeException, InvalidUsernameInputException, InvalidAccountIdException, InvalidContactInfo, InvalidPaymentInfoException {
        transportationRoute.setTransportationCompany("SJ");
        transportationRoute.setArrivalPoint("Stockholm");
        transportationRoute.setDeparturePoint("Orebro");
        transportationRoute.setEstimatedDeparture("07:13");
        transportationRoute.setEstimatedArrival("09:15");
        transportationRoute.setTicketPrice(100);
        routeService.createNewRoute(transportationRoute);

        account.setPaymentInfo("0761111111");
        account.setUsername("divby0exc");
        account.setContactInfo("dani@gmail.com");
        account.setAccountType("USER");
        accountService.saveAccount(account);
    }
    @Test
    void buyATicket() throws Exception {
    mockMvc.perform(post("/book_a_ticket/{accountId}/{routeId}",1,1))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().string(containsString("Thank you for buying a ticket for route Orebro to Stockholm")));

    assertEquals(1, bookingService.fetchActiveBookingList(1L).size());
    assertEquals(1, paymentService.fetchPaymentList(1L).size());
          }

    /*
    Borrowed from:
    https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
    */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}