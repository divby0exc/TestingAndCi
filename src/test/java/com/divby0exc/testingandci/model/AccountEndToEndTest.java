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

//    @LocalServerPort
//    private int port;

    @Test
    public void testCreateAndRetrieveAccount() {
        // Define the base URL for your REST API
        String baseUrl = "http://localhost:" + 8080 + "/create_account";

        // Create an HTTP request to create an account
        Account account = new Account();
        account.setUsername("Daniel");
        account.setContactInfo("daniel@gmail.com");
//        account.setPaymentInfo(123456);
        account.setAccountType("Standard");

        Account createdAccount = restTemplate.postForObject(baseUrl, account, Account.class);

        // Verify the response and account creation
        assertNotNull(createdAccount.getId());
        assertEquals("Daniel", createdAccount.getUsername());

        // You can add more end-to-end test scenarios here
    }
}