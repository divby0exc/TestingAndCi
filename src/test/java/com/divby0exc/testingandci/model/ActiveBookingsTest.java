package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import com.divby0exc.testingandci.service.ActiveBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class ActiveBookingsTest {

    @Mock
    private IActiveBookingsRepository repo;

    @InjectMocks
    private ActiveBookingService serviceWithMockedRepo;

    @Autowired
    private ActiveBookingService activeBookingService;
    @Autowired
    private MockMvc mockMvc;

    private ActiveBookings activeBookings = new ActiveBookings();
    private ActiveBookings activeBookings2 = new ActiveBookings();
    private ActiveBookings activeBookings3 = new ActiveBookings();

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

    @BeforeEach
    void init() {
        activeBookings.setRouteId(1L);
        activeBookings.setAccountId(2L);
        activeBookings2.setRouteId(2L);
        activeBookings2.setAccountId(2L);
        activeBookings3.setRouteId(3L);
        activeBookings3.setAccountId(2L);

        activeBookingService.createNewBooking(activeBookings);
        activeBookingService.createNewBooking(activeBookings2);
        activeBookingService.createNewBooking(activeBookings3);
    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenDeletingABooking() throws InvalidBookingIdException {

        List<ActiveBookings> activeBookingsList = new ArrayList<>(activeBookingService.fetchActiveBookingList(2L));

        assertEquals(3, activeBookingsList.size());

        activeBookingService.deleteBooking(activeBookingsList.get(0).getBookingId());

        assertEquals(2, activeBookingService.fetchActiveBookingList(2L).size());
    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenFetchingOneBooking() throws InvalidBookingIdException {
        ActiveBookings fetchedBooking = activeBookingService.fetchOneBooking(1L).orElse(null);

        assertNotNull(fetchedBooking);

        assertEquals(2L, fetchedBooking.getAccountId());
        assertEquals(1L, fetchedBooking.getBookingId());
        assertEquals(1L, fetchedBooking.getRouteId());
    }

    @Test
    public void testThatInvalidIdIsNotThrownWhenFetchingBookingList() {
        assertDoesNotThrow(() -> activeBookingService.fetchActiveBookingList(2L));
    }

    @Test
    public void testCreateBookingEndToEnd() throws Exception {
        mockMvc.perform(post("/activebooking/create_booking")
                        .content(asJsonString(new ActiveBookings(
                                        null,
                                        1L,
                                        1L
                                ))
                        )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetBookingEndToEnd() throws Exception {
        mockMvc.perform(get("/activebooking/get_booking/{accountId}"
                        , 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookingId")
                        .value(1L));

    }

    @Test
    public void testGetBookingListEndToEnd() throws Exception {
        mockMvc.perform(get("/activebooking/get_booking_list/{accountId}", 2L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].accountId", hasItems(2)))
                .andExpect(jsonPath("$[*].bookingId", hasItems(1, 2, 3)))
                .andExpect(jsonPath("$[*].routeId", hasItems(1, 2, 3)));

    }

    @Test
    public void testDeleteBookingEndToEnd() throws Exception {
        assertEquals(3, activeBookingService.fetchActiveBookingList(2L).size());

        mockMvc.perform(delete("/activebooking/delete_booking/{bookingId}", 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());

        assertEquals(2, activeBookingService.fetchActiveBookingList(2L).size());
    }

}