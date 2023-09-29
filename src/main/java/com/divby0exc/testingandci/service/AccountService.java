package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;


    /*Create custom exception for each unvalid fields*/

    @Override
    public Account saveAccount(Account newAccount) throws InvalidUsernameInputException, InvalidPaymentInfoException, InvalidContactInfo, InvalidAuthTypeException, InvalidAccountIdException {
        if (newAccount.getUsername() == null) {
            throw new InvalidUsernameInputException("Username cannot be null");
        } else if (newAccount.getUsername().isEmpty()) {
            throw new InvalidUsernameInputException("Username cannot be empty");
        } else if (newAccount.getContactInfo() == null) {
            throw new InvalidContactInfo("Contact info cannot be null");
        } else if(newAccount.getContactInfo().isEmpty()) {
            throw new InvalidContactInfo("Contact info cannot be empty");
        } else if (newAccount.getPaymentInfo() == null) {
            throw new InvalidPaymentInfoException("Payment info cannot be null");
        } else if(newAccount.getPaymentInfo().isEmpty()) {
            throw new InvalidPaymentInfoException("Payment info cannot be empty");
        } else if (newAccount.getAccountType() == null) {
            throw new InvalidAuthTypeException("Account type cannot be null");
        } else if(newAccount.getAccountType().isEmpty()) {
            throw new InvalidAuthTypeException("Account type cannot be empty");
        } else if (newAccount.getPaymentInfo().startsWith("07") && newAccount.getPaymentInfo().length() != 10) {
            throw new InvalidPaymentInfoException("A valid mobile number that starts with 07 needs to be 10 digits");
        } else if (newAccount.getPaymentInfo().startsWith("+46") && newAccount.getPaymentInfo().length() != 12) {
            throw new InvalidPaymentInfoException("A valid mobile number that starts with +46 should be 11 digits");
        } else if (!newAccount.getContactInfo().contains("@")) {
            throw new InvalidContactInfo("A valid email address must contain an @ symbol");
        } else if(newAccount.getId() == null) {
            throw new InvalidAccountIdException("No id has been given");
        }
        return repository.save(newAccount);
    }

    @Override
    public Account updateAccount(Account oldAccount) {

        return repository.save(oldAccount);
    }

    @Override
    public void deleteAccount(Long accountId) throws InvalidAccountIdException {
        if (!repository.existsById(accountId))
            throw new InvalidAccountIdException("No account matched with the given account id");

        repository.deleteById(accountId);
    }

    @Override
    public Optional<Account> fetchedAccount(Long accountId) throws InvalidAccountIdException {
        if (!repository.existsById(accountId))
            throw new InvalidAccountIdException("No account matched with the given account id");

        return repository.findById(accountId);
    }

    @Override
    public List<Account> fetchAllAccounts() {
        return repository.findAll();
    }
}
