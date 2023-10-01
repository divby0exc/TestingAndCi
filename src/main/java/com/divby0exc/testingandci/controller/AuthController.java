package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.util.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @PostMapping("login")
    public String signIn(@RequestBody Account authDetails) {
        return JWTUtil.createJWT(authDetails.getId().toString(), authDetails.getUsername());
    }
}
