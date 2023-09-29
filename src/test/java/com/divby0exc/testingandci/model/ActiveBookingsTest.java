package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.service.ActiveBookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class ActiveBookingsTest {

    @Mock
    private IActiveBookingsRepository repo;

    @InjectMocks
    private ActiveBookingService serviceWithMockedRepo;

    @Autowired
    private ActiveBookingService activeBookingService;

    private ActiveBookings activeBookings = new ActiveBookings();
    private ActiveBookings activeBookings2 = new ActiveBookings();
    private ActiveBookings activeBookings3 = new ActiveBookings();

    @BeforeEach
    void init() {
        activeBookings.setRouteId(1L);
        activeBookings.setAccountId(1L);
        activeBookings2.setRouteId(2L);
        activeBookings2.setAccountId(1L);
        activeBookings3.setRouteId(3L);
        activeBookings3.setAccountId(1L);
    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenDeletingABooking() throws InvalidBookingIdException {
        activeBookingService.createNewBooking(activeBookings);
        activeBookingService.createNewBooking(activeBookings2);
        activeBookingService.createNewBooking(activeBookings3);

        List<ActiveBookings> activeBookingsList = new ArrayList<>(activeBookingService.fetchBookingList());

        assertEquals(3, activeBookingsList.size());
    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenFetchingOneBooking() {

    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenFetchingBookingList() {

    }

}