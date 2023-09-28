package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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

        String baseUrl = "http://localhost:" + 8080 + "/auth/login";

        String jwt = JWTUtil.createJWT(account.getId().toString(), account.getUsername());

        assertNotNull(jwt);
    }
}