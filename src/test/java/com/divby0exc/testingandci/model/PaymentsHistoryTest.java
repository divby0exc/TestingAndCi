package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.service.PaymentHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PaymentsHistoryTest {
    @Autowired
    private PaymentHistoryService paymentsHistoryService;

    @Test
    public void testGettersAndSetters() {
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        paymentsHistory.setUsername("Daniel");
        paymentsHistory.setRouteId(123);

        assertEquals("Daniel", paymentsHistory.getUsername());
        assertEquals(123, paymentsHistory.getRouteId());
    }

    @Test
    public void testSaveAndRetrievePaymentsHistory() {
        // Create an instance of PaymentsHistory
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        paymentsHistory.setUsername("USER");
        paymentsHistory.setRouteId(123);

        // Save the PaymentsHistory entity to the database
        paymentsHistoryService.createPayment(paymentsHistory);

        // Retrieve the PaymentsHistory entity from the database
        PaymentsHistory retrievedPaymentsHistory = paymentsHistoryService.fetchPayment("USER").orElse(null);

        // Perform assertions to verify the save and retrieve operations
        assertEquals("USER", retrievedPaymentsHistory.getUsername());
        assertEquals(123, retrievedPaymentsHistory.getRouteId());
    }




}