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
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidArrivalPointInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Arrival point cannot be null",
                assertThrows(InvalidArrivalPointInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testThatTransportationCompanyDoesThrowInvalidTransportationCompanyInputWhenNull() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidTransportationCompanyInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Transportation company cannot be null",
                assertThrows(InvalidTransportationCompanyInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testThatTransportationCompanyDoesThrowInvalidTransportationCompanyInputWhenEmpty() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidTransportationCompanyInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Transportation company cannot be empty",
                assertThrows(InvalidTransportationCompanyInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testThatEstimatedArrivalDoesThrowInvalidEstimatedArrivalInputWhenNull() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidEstimatedArrivalInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Estimated arrival cannot be null",
                assertThrows(InvalidEstimatedArrivalInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
   }

    @Test
    public void testThatEstimatedArrivalDoesThrowInvalidEstimatedArrivalInputWhenEmpty() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidEstimatedArrivalInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Estimated arrival cannot be empty",
                assertThrows(InvalidEstimatedArrivalInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());

    }

    @Test
    public void testThatEstimatedDepartureDoesThrowInvalidEsitmatedDepartureInputWhenNull() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidEstimatedDepartureInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Estimated departure cannot be null",
                assertThrows(InvalidEstimatedDepartureInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testThatEstimatedDepartureDoesThrowInvalidEsitmatedDepartureInputWhenEmpty() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertThrows(InvalidEstimatedDepartureInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Estimated departure cannot be empty",
                assertThrows(InvalidEstimatedDepartureInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

    @Test
    public void testThatTicketPriceDoesThrowInvalidTicketPriceInputWhenValueIsLessOrEqualToZero() {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(0);

        assertThrows(InvalidTicketPriceInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Ticket price needs to have an actual price that you can pay",
                assertThrows(InvalidTicketPriceInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());

        testRoute.setTicketPrice(-100);

        assertThrows(InvalidTicketPriceInputException.class,
                () -> routeServiceWithMockedRepo.createNewRoute(testRoute));
        assertEquals("Ticket price needs to have an actual price that you can pay",
                assertThrows(InvalidTicketPriceInputException.class,
                        () -> routeServiceWithMockedRepo.createNewRoute(testRoute)).getMessage());
    }

                    /*  Real integration test   */
    @Test
    public void testThatCreateNewRouteDoesNotThrowException() throws InvalidEstimatedDepartureInputException, InvalidArrivalPointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidDeparturePointInputException, InvalidTicketPriceInputException {
        TransportationRoute testRoute = new TransportationRoute();
        testRoute.setRouteId(1L);
        testRoute.setTransportationCompany("SJ");
        testRoute.setArrivalPoint("Stockholm");
        testRoute.setDeparturePoint("Orebro");
        testRoute.setEstimatedDeparture("07:13");
        testRoute.setEstimatedArrival("09:15");
        testRoute.setTicketPrice(100);

        assertDoesNotThrow(() -> routeServiceWithMockedRepo.createNewRoute(testRoute));
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