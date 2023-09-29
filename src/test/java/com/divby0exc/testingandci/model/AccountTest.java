package com.divby0exc.testingandci.model;


import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AccountTest {

    @BeforeEach
    public void setup() {
        Account accountToTestFullIntegration = new Account();

    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsNotNull() {
        assertThrows(InvalidUsernameInputException.class, () -> method to invoke);
    }

    @Test
    public void testingSaveAccountMethodIfUsernameIsNotEmpty() {

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNotNull() {

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoIsNotEmpty() {

    }

    @Test
    public void testingSaveAccountMethodIfContactInfoContainsAnAtSymbol() {

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNotNull() {

    }

    @Test
    public void testingSaveAccountMethodIfPaymentInfoIsNotEmpty() {

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNotNull() {

    }

    @Test
    public void testingSaveAccountMethodIfAccountTypeIsNotEmpty() {

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_07_Is_10_Digits() {

    }

    @Test
    public void testingSaveAccountMethodIfPhoneNumberThatStartsWith_Plus46_Is_11_Digits() {

    }

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