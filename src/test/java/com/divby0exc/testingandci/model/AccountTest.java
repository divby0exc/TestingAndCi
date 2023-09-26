package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.handlerexception.InvalidPaymentInfoException;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import com.divby0exc.testingandci.handlerexception.NullValueException;
import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AccountService accountService;


    @Test
    public void testingEdgeCases() {
//        Account account = mock(Account.class);
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setUsername("divby0exc");
        account.setContactInfo("dani@gmail.com");

        assertNull(account.getUsername());
//        assertNotNull(account.getAccountType());
//        assertNotNull(account.getContactInfo());
//        assertNotNull(account.getPaymentInfo());
//        assertDoesNotThrow(account.setPaymentInfo("076"));

    }

    @Test
    public void testGettersAndSetters() {
        // Create a mock Account object
        Account account = mock(Account.class);

        // Define the behavior of the getters and setters
        when(account.getId()).thenReturn(1L);
        when(account.getUsername()).thenReturn("Dani");
        when(account.getContactInfo()).thenReturn("dani@gmail.com");
        when(account.getPaymentInfo()).thenReturn("123456");
        when(account.getAccountType()).thenReturn("USER");

        // Perform assertions to verify getter methods
        assertEquals(1L, account.getId());
        assertEquals("Dani", account.getUsername());
        assertEquals("dani@gmail.com", account.getContactInfo());
        assertEquals("123456", account.getPaymentInfo());
        assertEquals("USER", account.getAccountType());
    }

    @Test
    public void testCreateAndRetrieveAccount() {
        // Define the base URL for account creation endpoint
        String baseUrl = "http://localhost:" + 8080 + "/account/create_account";

        // Create an account object then
        // Make a HTTP req to save the account thro the endpoint
        Account account = new Account();
        account.setUsername("Dani");
        account.setContactInfo("dani@gmail.com");
        account.setPaymentInfo("123456");
        account.setAccountType("USER");

        Account createdAccount = restTemplate.postForObject(baseUrl, account, Account.class);

        // Verify the response and account creation
        assertNotNull(createdAccount.getId());
        assertEquals("Dani", createdAccount.getUsername());
        assertEquals("dani@gmail.com", createdAccount.getContactInfo());
        assertEquals("123456", createdAccount.getPaymentInfo());
        assertEquals("USER", createdAccount.getAccountType());
    }

    @Test
    public void testSaveAccount() throws InvalidUsernameInputException, InvalidPaymentInfoException, NullValueException {
//         Create an instance of Account
        Account account = new Account();
        account.setUsername("Dani");
        account.setContactInfo("dani@gmail.com");
        account.setPaymentInfo("123456");
        account.setAccountType("USER");

        // Save the account to the database
        Account savedAccount = accountService.saveAccount(account);

        // Retrieve the account from the database
        Account retrievedAccount = accountService.fetchedAccount(savedAccount.getId()).orElse(null);

        // Perform assertions to verify the save and retrieve operations
        assertNotNull(retrievedAccount);
        assertEquals("Dani", retrievedAccount.getUsername());
        assertEquals("dani@gmail.com", retrievedAccount.getContactInfo());
        assertEquals("123456", retrievedAccount.getPaymentInfo());
        assertEquals("USER", retrievedAccount.getAccountType());
        assertThrows(NullValueException.class, () -> accountService.saveAccount(account));

    }

    @Test
    public void testUpdateAccount() {

    }

    @Test
    public void testDeleteAccount() {

    }

}