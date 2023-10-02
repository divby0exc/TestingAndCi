package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.model.AuthDetails;
import com.divby0exc.testingandci.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<String> signIn(@RequestBody AuthDetails authDetails) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(JWTUtil.createJWT(authDetails.getId(), authDetails.getUsername()));
    }
}
