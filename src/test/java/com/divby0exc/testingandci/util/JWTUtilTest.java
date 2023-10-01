package com.divby0exc.testingandci.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilTest {

    @Test
    void createJWT() {
        String jwt = JWTUtil.createJWT("1234567890", "1234567890");
        assertNotNull(jwt);
    }
}