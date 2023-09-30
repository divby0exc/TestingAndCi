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

import java.util.Optional;

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

        discountRoute.setDiscountPrice(50);
        assertThrows(InvalidRouteIdException.class,
                () -> routeServiceWithMockedRepo.updateRouteDiscount(discountRoute));
        assertEquals("The given route ID was not found",
                assertThrows(InvalidRouteIdException.class,
                        () -> routeServiceWithMockedRepo.updateRouteDiscount(testRoute)).getMessage());
    }

    @Test
    public void testThatFetchAllRoutesThrowRoutesIsEmptyWhenEmpty() {
        assertThrows(TransportationRoutesIsEmptyException.class,
                () -> routeServiceWithMockedRepo.fetchAllRoutes());
        assertEquals("Route list is empty",
                assertThrows(TransportationRoutesIsEmptyException.class,
                        () -> routeServiceWithMockedRepo.fetchAllRoutes()).getMessage());
    }

    @Test
    public void testThatGetOneRouteDoesThrowInvalidRouteIdWhenIdDoesNotExist() throws InvalidRouteIdException {
        assertThrows(InvalidRouteIdException.class,
                () -> routeServiceWithMockedRepo.getOneRoute(1L));
        assertEquals("The given route ID was not found",
                assertThrows(InvalidRouteIdException.class,
                        () -> routeServiceWithMockedRepo.getOneRoute(1L)).getMessage());
    }

    @Test
    public void testSaveMehtodThatDeparturePointDoesThrowInvalidDeparturePointInputWhenEmpty() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidDeparturePointInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Departure point cannot be empty",
                assertThrows(InvalidDeparturePointInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testSaveMethodThatDeparturePointDoesThrowInvalidDeparturePointInputWhenNull() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidDeparturePointInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Departure point cannot be null",
                assertThrows(InvalidDeparturePointInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testSaveMethodThatArrivalPointDoesThrowInvalidArrivalPointInputWhenEmpty() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidArrivalPointInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Arrival point cannot be empty",
                assertThrows(InvalidArrivalPointInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testSaveMethodThatArrivalPointDoesThrowInvalidArrivalPointInputWhenNull() {

    }

    @Test
    public void testThatTransportationCompanyDoesThrowInvalidTransportationCompanyInputWhenNull() {

    }

    @Test
    public void testThatTransportationCompanyDoesThrowInvalidTransportationCompanyInputWhenEmpty() {

    }

    @Test
    public void testThatEstimatedArrivalDoesThrowInvalidEstimatedArrivalInputWhenNull() {

    }

    @Test
    public void testThatEstimatedArrivalDoesThrowInvalidEstimatedArrivalInputWhenEmpty() {

    }

    @Test
    public void testThatEstimatedDepartureDoesThrowInvalidEsitmatedDepartureInputWhenNull() {

    }

    @Test
    public void testThatEstimatedDepartureDoesThrowInvalidEsitmatedDepartureInputWhenEmpty() {

    }

    @Test
    public void testThatTicketPriceDoesThrowInvalidTicketPriceInputWhenValueIsLessOrEqualToZero() {

    }

                    /*  Real integration test   */
    @Test
    public void testThatCreateNewRouteDoesNotThrowException() {

    }

    @Test
    public void testThatUpdateRouteDoesNotThrowException() {

    }

    @Test
    public void testThatFetchAllRoutesDoesNotThrowException() {

    }

    @Test
    public void testThatGetOneRouteDoesNotThrowException() {

    }

        /*    End to End test     */

    @Test
    public void endToEndTest() {

    }



}