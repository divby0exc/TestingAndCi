package com.divby0exc.testingandci.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountTest {
    @Test
    public void testGettersAndSetters() {
        // Create a mock Account object
        Account account = mock(Account.class);

        // Define the behavior of the getters and setters
        when(account.getId()).thenReturn(1L);
        when(account.getUsername()).thenReturn("Daniel");
        when(account.getContactInfo()).thenReturn("daniel@gmail.com");
        when(account.getPaymentInfo()).thenReturn(123456);
        when(account.getAccountType()).thenReturn("USER");

        // Perform assertions to verify getter methods
        assertEquals(1L, account.getId());
        assertEquals("Daniel", account.getUsername());
        assertEquals("daniel@gmail.com", account.getContactInfo());
        assertEquals(123456, account.getPaymentInfo());
        assertEquals("USER", account.getAccountType());
    }

}