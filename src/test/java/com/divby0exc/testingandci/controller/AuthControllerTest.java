package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AuthControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    AccountService accountService;

    @Test
    void signIn() throws InvalidAccountIdException, InvalidAuthTypeException, InvalidUsernameInputException, InvalidContactInfo, InvalidPaymentInfoException {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setUsername("Dani");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        accountService.saveAccount(account);

        Account fetchAccount = accountService.fetchedAccount(1L).orElse(null);

        String baseUrl = "http://localhost:" + 8080 + "/auth/login";
        assertTrue(testRestTemplate.postForEntity(baseUrl, fetchAccount, Account.class).getStatusCode().is2xxSuccessful());
    }
}