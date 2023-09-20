package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.service.ActiveBookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ActiveBookingsTest {
    @Autowired
    private ActiveBookingService activeBookingService;
    @Test
    public void testGettersAndSetters() {
        // Create an instance of ActiveBookings
        ActiveBookings activeBookings = new ActiveBookings();
        activeBookings.setUsername("USER");
        activeBookings.setRouteId(123);

        // Perform assertions to verify getter methods
        assertNotNull(activeBookings);
        assertEquals("USER", activeBookings.getUsername());
        assertEquals(123, activeBookings.getRouteId());
    }

    @Test
    public void testSaveAndRetrieveActiveBooking() {
        // Create an instance of ActiveBookings
        ActiveBookings activeBookings = new ActiveBookings();
                activeBookings.setUsername("Daniel");
                activeBookings.setRouteId(123);

        // Save the ActiveBookings entity to the database
        activeBookingService.createNewBooking(activeBookings);

        // Retrieve the ActiveBookings entity from the database
        ActiveBookings retrievedActiveBookings = activeBookingService.fetchOneBooking(activeBookings.getId()).orElse(null);

        // Perform assertions to verify the save and retrieve operations
        assertNotNull(retrievedActiveBookings);
        assertEquals("Daniel", retrievedActiveBookings.getUsername());
        assertEquals(123, retrievedActiveBookings.getRouteId());
    }
}