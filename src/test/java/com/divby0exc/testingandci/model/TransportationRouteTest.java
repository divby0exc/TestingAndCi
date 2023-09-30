package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import com.divby0exc.testingandci.service.TransportationRouteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TransportationRouteTest {
    @Mock
    ITransportationRouteRepository repo;

    @InjectMocks
    TransportationRouteService routeServiceWithMockedRepo;

    @Autowired
    TransportationRouteService routeService;

    private TransportationRoute transportationRoute = new TransportationRoute();

    @BeforeEach
    void init() {

    }

    @Test
    public void testThatUpdateRouteThrowInvalidRouteIdWhenMissing() throws InvalidEstimatedDepartureInputException, InvalidArrivalPointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidDeparturePointInputException, InvalidTicketPriceInputException, InvalidRouteIdException {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        routeServiceWithMockedRepo.createNewRoute(testRoute);

        TransportationRoute discountRoute = new TransportationRoute();

        discountRoute.setRouteId(1L);
        discountRoute.setDiscountPrice(50);


    }

    @Test
    public void testThatFetchAllRoutesDoesNotThrowRoutesIsEmpty() {

    }

    @Test
    public void testThatGetOneRouteDoesNotThrowInvalidRouteId() {

    }

    @Test
    public void testSaveMehtodThatDeparturePointDoesNotThrowInvalidDeparturePointInputWhenEmpty() {

    }

    @Test
    public void testSaveMehtodThatDeparturePointDoesNotThrowInvalidDeparturePointInputWhenNull() {

    }

    @Test
    public void testSaveMethodThatArrivalPointDoesNotThrowInvalidArrivalPointInputWhenEmpty() {

    }

    @Test
    public void testSaveMethodThatArrivalPointDoesNotThrowInvalidArrivalPointInputWhenNull() {

    }

    @Test
    public void testThatTransportationCompanyDoesNotThrowInvalidTransportationCompanyInputWhenNull() {

    }

    @Test
    public void testThatTransportationCompanyDoesNotThrowInvalidTransportationCompanyInputWhenEmpty() {

    }

    @Test
    public void testThatEstimatedArrivalDoesNotThrowInvalidEstimatedArrivalInputWhenNull() {

    }

    @Test
    public void testThatEstimatedArrivalDoesNotThrowInvalidEstimatedArrivalInputWhenEmpty() {

    }

    @Test
    public void testThatEstimatedDepartureDoesNotThrowInvalidEsitmatedDepartureInputWhenNull() {

    }

    @Test
    public void testThatEstimatedDepartureDoesNotThrowInvalidEsitmatedDepartureInputWhenEmpty() {

    }

    @Test
    public void testThatTicketPriceDoesNotThrowInvalidTicketPriceInputWhenValueIsLessOrEqualToZero() {

    }

    @Test
    public void endToEndTest() {

    }



}