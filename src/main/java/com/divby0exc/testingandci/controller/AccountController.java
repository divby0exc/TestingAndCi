package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidAuthTypeException;
import com.divby0exc.testingandci.handlerexception.InvalidContactInfo;
import com.divby0exc.testingandci.handlerexception.InvalidPaymentInfoException;
import com.divby0exc.testingandci.handlerexception.InvalidUsernameInputException;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account/")
public class AccountController {
    @Autowired
    private AccountService accountService;
//    POST
//    Delete
//    PUT
//    GET

    @PostMapping("create_account")
    public Account saveAccount(@RequestBody Account account) throws InvalidUsernameInputException, InvalidPaymentInfoException, InvalidAuthTypeException, InvalidContactInfo {
        return accountService.saveAccount(account);
    }

    @GetMapping("get_account/{id}")
    public Optional<Account> fetchAccount(@PathVariable Long id) {
        return accountService.fetchedAccount(id);
    }
}
