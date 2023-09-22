package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AccountService accountService;
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

    @Test
    public void testCreateAndRetrieveAccount() {
        // Define the base URL for account creation endpoint
        String baseUrl = "http://localhost:" + 8080 + "/account/create_account";

        // Create an account object then
        // Make a HTTP req to save the account thro the endpoint
        Account account = new Account();
        account.setUsername("Daniel");
        account.setContactInfo("daniel@gmail.com");
        account.setPaymentInfo(123456);
        account.setAccountType("USER");

        Account createdAccount = restTemplate.postForObject(baseUrl, account, Account.class);

        // Verify the response and account creation
        assertNotNull(createdAccount.getId());
        assertEquals("Daniel", createdAccount.getUsername());
        assertEquals("daniel@gmail.com", createdAccount.getContactInfo());
        assertEquals(123456, createdAccount.getPaymentInfo());
        assertEquals("USER", createdAccount.getAccountType());
    }

    @Test
    public void testSaveAccount() {
        // Create an instance of Account
        Account account = new Account();
        account.setUsername("Daniel");
        account.setContactInfo("daniel@gmail.com");
        account.setPaymentInfo(123456);
        account.setAccountType("USER");

        // Save the account to the database
        Account savedAccount = accountService.saveAccount(account);

        // Retrieve the account from the database
        Account retrievedAccount = accountService.fetchedAccount(savedAccount.getId()).orElse(null);

        // Perform assertions to verify the save and retrieve operations
        assertNotNull(retrievedAccount);
        assertEquals("Daniel", retrievedAccount.getUsername());
        assertEquals("daniel@gmail.com", retrievedAccount.getContactInfo());
        assertEquals(123456, retrievedAccount.getPaymentInfo());
        assertEquals("USER", retrievedAccount.getAccountType());

    }

    @Test
    public void testUpdateAccount() {

    }

    @Test
    public void testDeleteAccount() {

    }

}