package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<String> signIn(@RequestBody Account authDetails) {
        String token = JWTUtil.sign(authDetails);

        return ResponseEntity
                .ok(token);

    }
}
