package com.divby0exc.testingandci.model;
import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

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


    }
}