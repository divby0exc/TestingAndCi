package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.repository.IAccountRepository;
import com.divby0exc.testingandci.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class AccountTest {

    @Mock
    private IAccountRepository repo;
    @InjectMocks
    private AccountService accountServiceMockedRepo;

    @Autowired
    private AccountService accountService;
    @Autowired
    private MockMvc mockMvc;

    private Account accountToTestFullIntegration = new Account();

    @BeforeEach
    void init() {
        accountToTestFullIntegration.setPaymentInfo("0761111111");
        accountToTestFullIntegration.setUsername("divby0exc");
        accountToTestFullIntegration.setContactInfo("dani@gmail.com");
        accountToTestFullIntegration.setAccountType("USER");
    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");

        assertThrows(InvalidUsernameInputException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Username cannot be null",
                assertThrows(InvalidUsernameInputException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());
    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("");

        assertThrows(InvalidUsernameInputException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Username cannot be empty",
                assertThrows(InvalidUsernameInputException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfUserInputsAnythingElseThenUSERorADMINorPROVIDER() {
        Account account = new Account();
        account.setAccountType("Sasuke");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidAuthTypeException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Account type must either be 'USER', 'ADMIN' or 'PROVIDER'",
                assertThrows(InvalidAuthTypeException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());
    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setUsername("divby0exc");

        assertThrows(InvalidContactInfo.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Contact info cannot be null",
                assertThrows(InvalidContactInfo.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("");
        account.setUsername("divby0exc");

        assertThrows(InvalidContactInfo.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Contact info cannot be empty",
                assertThrows(InvalidContactInfo.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoDoNotContainsAnAtSymbol() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("danigmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidContactInfo.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("A valid email address must contain an @ symbol",
                assertThrows(InvalidContactInfo.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());
    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNull() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Payment info cannot be null",
                assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account)).getMessage());
    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsEmpty() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Payment info cannot be empty",
                assertThrows(InvalidPaymentInfoException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNull() {
        Account account = new Account();
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidAuthTypeException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Account type cannot be null",
                assertThrows(InvalidAuthTypeException.class,
                () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsEmpty() {
        Account account = new Account();
        account.setAccountType("");
        account.setPaymentInfo("0761111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        assertThrows(InvalidAuthTypeException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("Account type cannot be empty",
                assertThrows(InvalidAuthTypeException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_07_Is_Not_10_Digits() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("076111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        //        Testing with 9 digits
        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("A valid mobile number that starts with 07 needs to be 10 digits",
                assertThrows(InvalidPaymentInfoException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

        //        Testing with 11 digits
        account.setPaymentInfo("07611111111");
        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("A valid mobile number that starts with 07 needs to be 10 digits",
                assertThrows(InvalidPaymentInfoException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_Plus46_Is_Not_12_Digits() {
        Account account = new Account();
        account.setAccountType("USER");
        account.setPaymentInfo("+4676111111");
        account.setContactInfo("dani@gmail.com");
        account.setUsername("divby0exc");

        //        Testing with 11 digits
        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("A valid mobile number that starts with +46 should be 12 digits",
                assertThrows(InvalidPaymentInfoException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

        //        Testing with 13 digits
        account.setPaymentInfo("+467611111111");
        assertThrows(InvalidPaymentInfoException.class,
                () -> accountServiceMockedRepo.saveAccount(account));
        assertEquals("A valid mobile number that starts with +46 should be 12 digits",
                assertThrows(InvalidPaymentInfoException.class,
                        () -> accountServiceMockedRepo.saveAccount(account)).getMessage());

    }

                /*  Real integration test   */
    @Test
    public void testSaveMethodToDatabaseThatNoExceptionIsThrown() {
        assertNotNull(accountToTestFullIntegration);
        assertDoesNotThrow(() -> accountService.saveAccount(accountToTestFullIntegration));
    }

    @Test
    public void testUpdateMethodToDatabaseThatNoExceptionIsThrown() throws InvalidAuthTypeException, InvalidUsernameInputException, InvalidAccountIdException, InvalidContactInfo, InvalidPaymentInfoException {
        assertNotNull(accountToTestFullIntegration);

        accountService.saveAccount(accountToTestFullIntegration);
        assertEquals("divby0exc", accountToTestFullIntegration.getUsername(), "Username of account I just saved was not divby0exc");

        List<Account> accountList = new ArrayList<>(accountService.fetchAllAccounts());

        assertEquals(1, accountList.size());

        Account retrievedAcc = accountService.fetchedAccount(1L).orElse(null);
        assertNotNull(retrievedAcc, "The retrieved account is null");
        retrievedAcc.setUsername("pookey");
        accountService.updateAccount(retrievedAcc);

        accountList = new ArrayList<>(accountService.fetchAllAccounts());

        assertEquals(1, accountList.size());

        Account retrievedAccAfterUsernameChange = accountService.fetchedAccount(1L).orElse(null);
        assertNotNull(retrievedAccAfterUsernameChange, "Retrieved acc after username change is null");

        assertEquals("pookey", retrievedAccAfterUsernameChange.getUsername(), "Username did not get updated to pookey");

    }

    @Test
    public void testDeleteMethodFromDatabaseThatNoExceptionIsThrown() throws InvalidAuthTypeException, InvalidUsernameInputException, InvalidAccountIdException, InvalidContactInfo, InvalidPaymentInfoException {
        assertNotNull(accountToTestFullIntegration);

        assertDoesNotThrow(() -> accountService.saveAccount(accountToTestFullIntegration));

        List<Account> accountList = new ArrayList<>(accountService.fetchAllAccounts());

        assertEquals(1, accountList.size());

        Account fetchedAccount = accountService.fetchedAccount(1L).orElse(null);
        assertNotNull(fetchedAccount);

        assertDoesNotThrow(() -> accountService.deleteAccount(fetchedAccount.getId()));

        accountList = new ArrayList<>(accountService.fetchAllAccounts());

        assertEquals(0, accountList.size());
    }

    @Test
    public void testFetchedAccountMethodThatNoExceptionIsThrown() throws InvalidAuthTypeException, InvalidUsernameInputException, InvalidAccountIdException, InvalidContactInfo, InvalidPaymentInfoException {
        assertNotNull(accountToTestFullIntegration);

        accountService.saveAccount(accountToTestFullIntegration);

        assertDoesNotThrow(() -> accountService.fetchedAccount(1L));
    }

                    /*  End to End test     */

    @Test
    public void testEndToEndCreateAccountEndpoint() throws Exception {
        mockMvc.perform(post("/account/create_account")
                .content(asJsonString(
                        new Account()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testEndToEndUpdateAccountEndpoint() {

    }

    @Test
    public void testEndToEndDeleteAccountEndpoint() {

    }

    @Test
    public void testEndToEndGetAccountEndpoint() {

    }

    /*
    Borrowed from:
    https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
    */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}