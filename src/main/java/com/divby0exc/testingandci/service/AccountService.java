package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository repository;

    @Override
    public Account saveAccount(Account newAccount) {
        return null;
    }

    @Override
    public Account updateAccount(Account oldAccount) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public Account fetchedAccount(Long accountId) {
        return null;
    }
}
