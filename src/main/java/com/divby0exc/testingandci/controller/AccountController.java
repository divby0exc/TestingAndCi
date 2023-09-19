package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    // Save operation
    @PostMapping("/create_account")
    public Account saveAccount() {
        Account account = Account.builder()
                .username("Josef")
                .contactInfo("112")
                .accountType("ADMIN")
                .paymentInfo(112)
                .build();
        return accountService.saveAccount(account);
    }
}
