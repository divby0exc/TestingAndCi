package com.divby0exc.testingandci.model;
import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountRepositoryIntegrationTest {

    @Autowired
    private AccountService accountService;

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
}