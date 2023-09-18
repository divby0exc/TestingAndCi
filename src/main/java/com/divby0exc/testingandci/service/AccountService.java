package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    IAccountRepository repository;
}
