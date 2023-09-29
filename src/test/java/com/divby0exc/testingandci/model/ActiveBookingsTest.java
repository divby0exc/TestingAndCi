package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import com.divby0exc.testingandci.service.ActiveBookingService;
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
class ActiveBookingsTest {

    @Mock
    private IActiveBookingsRepository repo;

    @InjectMocks
    private ActiveBookingService serviceWithMockedRepo;

    @Autowired
    private ActiveBookingService activeBookingService;

    @Test
    public void testThatInvalidIdIsNotThrownWhenDeletingABooking() {

    }

    @Test
    public void  testThatInvalidIdIsNotThrownWhenFetchingOneBooking() {

    }

}