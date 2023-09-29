package com.divby0exc.testingandci.model;


import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidAuthTypeException;
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
    public void testingSaveAccountMethodIfUsernameIsNull() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");

        assertThrows(InvalidUsernameInputException.class, () -> accountServiceMockedRepo.saveAccount(account));
    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsEmpty() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("");

        assertThrows(InvalidUsernameInputException.class, () -> accountServiceMockedRepo.saveAccount(account));

    }

    @Test
    public void testingSaveAccountMethodIfUserInputsAnythingElseThenUSERorADMINorPROVIDER() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("Sasuke");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidAuthTypeException.class, () -> accountServiceMockedRepo.saveAccount(account));
    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNull() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsEmpty() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoDoNotContainsAnAtSymbol() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNull() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsEmpty() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNull() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsEmpty() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_07_Is_10_DigitsInsteadOf_11() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_Plus46_Is_11_DigitsInsteadOf_12() {
        Account account = new Account();
        account.setId(1L);
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

                    /*  End to End test     */

    @Test
    public void endToEndTest() {

    }
}