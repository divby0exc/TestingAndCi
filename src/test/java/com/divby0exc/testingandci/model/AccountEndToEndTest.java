package com.divby0exc.testingandci.model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountEndToEndTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testCreateAndRetrieveAccount() {
        // Define the base URL for account creation endpoint
        String baseUrl = "http://localhost:" + 8080 + "/create_account";

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
    }
}