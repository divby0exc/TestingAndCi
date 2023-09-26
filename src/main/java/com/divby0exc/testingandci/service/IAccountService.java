package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidPaymentInfoException;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import com.divby0exc.testingandci.handlerexception.NullValueException;
import com.divby0exc.testingandci.model.Account;

import java.util.Optional;

public interface IAccountService {
    /*Create new account*/
    Account saveAccount(Account newAccount) throws InvalidUsernameInputException, NullValueException, InvalidPaymentInfoException;

    /*Update field*/
    Account updateAccount(Account oldAccount);

    /*Delete account*/
    void deleteAccount(Long accountId);

    /*Fetch account*/
    Optional<Account> fetchedAccount(Long accountId);
}
