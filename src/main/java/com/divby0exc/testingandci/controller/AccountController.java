package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account/")
public class AccountController {
    @Autowired
    private AccountService accountService;


    //    POST
    @PostMapping("create_account")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) throws InvalidUsernameInputException, InvalidPaymentInfoException, InvalidAuthTypeException, InvalidContactInfo, InvalidAccountIdException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(accountService.saveAccount(account));
    }

    //    GET
    @GetMapping("get_account/{id}")
    public ResponseEntity<Optional<Account>> fetchAccount(@PathVariable Long id) throws InvalidAccountIdException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.fetchedAccount(id));
    }

    //    PUT
    @PutMapping("update_account/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) throws InvalidAuthTypeException, InvalidUsernameInputException, InvalidContactInfo, InvalidPaymentInfoException, InvalidAccountIdException {
        account.setId(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(accountService.saveAccount(account));
    }

    //    Delete
    @DeleteMapping("delete_account/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long id) throws InvalidAccountIdException {
        accountService.deleteAccount(id);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
