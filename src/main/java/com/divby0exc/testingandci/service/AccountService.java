package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.repository.IAccountRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;


    /*Create custom exception for each unvalid fields*/

    @Override
    public Account saveAccount(Account newAccount) {
        if(newAccount.getUsername()!= null) {
            if(newAccount.getContactInfo()!=null) {
                if(newAccount.getDigitCount(newAccount.getPaymentInfo())==10) {
                    if(newAccount.getAccountType()!=null) {
                        return repository.save(newAccount);
                    } else {
                        throw new NullPointerException("Account type cannot be null");
                    }
                } else {
                    System.out.println(newAccount.getPaymentInfo() + " is not a valid mobile number");
                }
            } else {
                System.out.println("Email cannot be null");
            }
        } else {
            System.out.println("Username cannot be null");
        }
        return new Account();
    }

    @Override
    public Account updateAccount(Account oldAccount) {
        return repository.save(oldAccount);
    }

    @Override
    public void deleteAccount(Long accountId) {
        repository.deleteById(accountId);

    }

    @Override
    public Optional<Account> fetchedAccount(Long accountId) {
        return repository.findById(accountId);
    }
}
