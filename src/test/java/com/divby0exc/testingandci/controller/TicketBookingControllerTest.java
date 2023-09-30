package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class TicketBookingControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void buyATicket() {
    }
}