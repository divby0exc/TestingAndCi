package com.divby0exc.testingandci.model;


import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import com.divby0exc.testingandci.repository.IAccountRepository;
import com.divby0exc.testingandci.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Mock
    private IAccountRepository repo;
    @InjectMocks
    private AccountService accountServiceMockedRepo;

    @Autowired
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        Account accountToTestFullIntegration = new Account();

    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsNotNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidUsernameInputException.class, () -> accountServiceMockedRepo.saveAccount(account));
    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsNotEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNotNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNotEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoContainsAnAtSymbol() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNotNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNotEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNotNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNotEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_07_Is_10_Digits() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_Plus46_Is_11_Digits() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

                /*  Real integration test   */
    @Test
    public void testSaveMethodToDatabaseThatNoExceptionIsThrown() {

    }

    @Test
    public void testUpdateMethodToDatabaseThatNoExceptionIsThrown() {

    }

    @Test
    public void testDeleteMethodFromDatabaseThatNoExceptionIsThrown() {

    }

    @Test
    public void testFetchedAccountMethodThatNoExceptionIsThrown() {

    }
}