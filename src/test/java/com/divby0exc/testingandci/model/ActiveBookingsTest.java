package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.service.ActiveBookingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActiveBookingsTest {
    @Autowired
    private ActiveBookingService activeBookingService;
    @Autowired
    private TestRestTemplate restTemplate;

    private MockMvc mockMvc;
    @Autowired
    TestRestTemplate testRestTemplate;

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

    @Test
    public void testCreateAndRetrieveActiveBooking() {

        String baseUrl = "http://localhost:" + 8080 + "/active-bookings/create";

        // Create an HTTP request to create an active booking
        ActiveBookings activeBookings = new ActiveBookings();
        activeBookings.setUsername("Daniel");
        activeBookings.setRouteId(123);

        ActiveBookings createdActiveBookings = testRestTemplate.postForObject(baseUrl, activeBookings, ActiveBookings.class);
        testRestTemplate.postForEntity(baseUrl, activeBookings, ActiveBookings.class).getStatusCode().is2xxSuccessful();

        // Verify the response and active booking creation
        assertNotNull(createdActiveBookings.getUsername());
        assertEquals(123, createdActiveBookings.getRouteId());
    }
}