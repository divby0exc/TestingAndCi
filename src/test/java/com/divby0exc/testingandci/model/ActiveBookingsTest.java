package com.divby0exc.testingandci.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActiveBookingsTest {
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
}