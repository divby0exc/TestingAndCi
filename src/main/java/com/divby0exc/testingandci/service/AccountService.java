package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidPaymentInfoException;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import com.divby0exc.testingandci.handlerexception.NullValueException;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;


    /*Create custom exception for each unvalid fields*/

    @Override
    public Account saveAccount(Account newAccount) throws InvalidUsernameInputException, NullValueException, InvalidPaymentInfoException {
        if (newAccount.getUsername().equals(null)) {
            throw new NullValueException("Username cannot be null");
        } else if (newAccount.getContactInfo().equals(null)) {
            throw new NullValueException("Contact info cannot be null");
        } else if (newAccount.getPaymentInfo().equals(null)) {
            throw new NullValueException("Payment info cannot be null");
        } else if (newAccount.getAccountType().equals(null)) {
            throw new NullValueException("Account type cannot be null");
        } else if(newAccount.getPaymentInfo().length()!=10 && newAccount.getPaymentInfo().startsWith("07")) {
            throw new InvalidPaymentInfoException("A valid mobile number that starts with 07 needs to be 10 digits");
        } else if(newAccount.getPaymentInfo().startsWith("+46") && newAccount.getPaymentInfo().length()!=11) {
            throw new InvalidPaymentInfoException("A valid mobile number that starts with +46 should be 11 digits");
        }
    return repository.save(newAccount);
    }

@Override public Account updateAccount(Account oldAccount){
        return repository.save(oldAccount);
        }

@Override public void deleteAccount(Long accountId){
        repository.deleteById(accountId);
        }

@Override public Optional<Account> fetchedAccount(Long accountId){
        return repository.findById(accountId);
        }
        }
